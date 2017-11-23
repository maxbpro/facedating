package maxb.facedating.controllers;

import maxb.facedating.aws.AwsS3Service;
import maxb.facedating.dao.UserRolesRepository;
import maxb.facedating.domain.Role;
import maxb.facedating.domain.User;
import maxb.facedating.domain.enums.Gender;
import maxb.facedating.domain.rest.FacePlusResult;
import maxb.facedating.faceplus.FacePlusService;
import maxb.facedating.geo.RestCountriesService;
import maxb.facedating.geo.model.City;
import maxb.facedating.geo.model.Country;
import maxb.facedating.geo.model.Region;
import maxb.facedating.security.CustomUserDetails;
import maxb.facedating.security.CustomUserDetailsService;
import maxb.facedating.security.SecurityService;
import maxb.facedating.service.UserService;
import maxb.facedating.validator.UserRegisterFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by MaxB on 08/11/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private SecurityService securityService;

    @Autowired
    UserService userService;

    @Autowired
    UserRegisterFormValidator userFormValidator;

    @Autowired
    AwsS3Service awsS3Service;

    @Autowired
    FacePlusService facePlusService;

    @Autowired
    private RestCountriesService restCountriesService;


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields(new String[]{"inputFile"});
        binder.setValidator(userFormValidator);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Date.class, "birthdate", new CustomDateEditor(dateFormatter, true));
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {

        model.addAttribute("userForm", new User());

        model.addAttribute("genderEnum", Gender.values());

        List<Country> countriesList = restCountriesService.getCountries();

        Map<Long,String> countryMap = new LinkedHashMap<>();

        for(Country country : countriesList){
            countryMap.put(country.getId(), country.getTitle());
        }

        model.addAttribute("countries", countryMap);

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("userForm") @Validated User user, BindingResult result,
                                  @RequestParam("inputFile") MultipartFile inputFile,
                                  Model model, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "register";
        } else {

            String photoUrl = awsS3Service.s3UploadMultipartFile(user.getUsername(), inputFile);

            if(photoUrl != null){

                String faceToken = facePlusService.detect(photoUrl);

                if(faceToken != null){

                    FacePlusResult facePlusResult = facePlusService.createFaceset(user.getUsername(), "", null);
                    String facesetToken = facePlusResult.getFacesetToken();

                    if(facesetToken != null){

                        FacePlusResult addFaceResult = facePlusService.addFaceIntoFaceset(facesetToken, faceToken);

                        if(addFaceResult.getErrorMessage() == null){

                            user.setPhotoUrl(photoUrl);
                            user.setFaceToken(faceToken);
                            user.setFacesetToken(facesetToken);

                            userService.save(user);

                        }else{
                            redirectAttributes.addFlashAttribute("msg", "addFaceResult.getErrorMessage()");
                            return "redirect:/user/register";
                        }

                    }else{
                        redirectAttributes.addFlashAttribute("msg", "Can't create a faceset! ");
                        return "redirect:/user/register";
                    }

                    //List<User> userList = userService.listUsers();

                    redirectAttributes.addFlashAttribute("msg", "User added successfully!");

                }else{
                    //photo is bad
                    redirectAttributes.addFlashAttribute("msg", "Can't detect a face! You should use another photo");
                    return "redirect:/user/register";
                }




                return "redirect:/user/" + user.getId();

            }else{
                redirectAttributes.addFlashAttribute("msg", "Can't upload a photo");
                return "redirect:/user/register";
            }



        }


    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView profile(@PathVariable("userId") long userId, Model model) throws IOException {

        ModelAndView modelAndView = new ModelAndView("user/user");

        User user = userService.findByUserId(userId);
        modelAndView.addObject("user", user);
        model.addAttribute("genderEnum", Gender.values());

        List<Country> countriesList = restCountriesService.getCountries();
        //List<Region> regionsList = restCountriesService.getRegions(user.getCountryId(), null);
        //List<City> citiesList = restCountriesService.getCities(user.getCountryId(), user.getRegionId(), null);

        Map<Long,String> countryMap = new LinkedHashMap<>();

        for(Country country : countriesList){
            countryMap.put(country.getId(), country.getTitle());
        }

        model.addAttribute("countries", countryMap);


        return modelAndView;
    }

    @RequestMapping(value = "/{userId}/update", method = RequestMethod.POST)
    public String updateProfile(@PathVariable("userId") long userId,
                                @ModelAttribute("user") User user,
                                BindingResult result, RedirectAttributes redirectAttributes) throws IOException {

        if (result.hasErrors()) {

            //error
            return "redirect:/user/" + user.getId();
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if(user.getId() == null){

                //error
                redirectAttributes.addFlashAttribute("msg", "User doesn't exist!");
                return "redirect:/user/" + user.getId();

            }else{

                User oldUser = userService.findByUserId(user.getId());
                oldUser.setFirstName(user.getFirstName());
                oldUser.setLastName(user.getLastName());
                oldUser.setEmail(user.getEmail());
                oldUser.setBirthdate(user.getBirthdate());

                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");

                userService.update(oldUser);

                //User saved = userService.findByUserId(user.getId());

                return "redirect:/user/" + user.getId();
            }



        }
    }

    @RequestMapping(value = "/{userId}/updatePhoto", method = RequestMethod.POST)
    public String updatePhoto(@PathVariable("userId") long userId,
                              @RequestParam("inputFile") MultipartFile inputFile,
                              RedirectAttributes redirectAttributes) {

        User user = userService.findByUserId(userId);

        String photoUrl = awsS3Service.s3UploadMultipartFile(user.getUsername(), inputFile);

        if(photoUrl != null){

            String faceToken = facePlusService.detect(photoUrl);

            if(faceToken != null){

                FacePlusResult facePlusResult = facePlusService.createFaceset(user.getUsername(), "", null);
                String facesetToken = facePlusResult.getFacesetToken();

                if(facesetToken != null){

                    FacePlusResult addFaceResult = facePlusService.addFaceIntoFaceset(facesetToken, faceToken);

                    if(addFaceResult.getErrorMessage() == null){

                        user.setPhotoUrl(photoUrl);
                        user.setFaceToken(faceToken);
                        user.setFacesetToken(facesetToken);

                        userService.save(user);

                    }else{
                        redirectAttributes.addFlashAttribute("msg", "addFaceResult.getErrorMessage()");
                        return "redirect:/user/" + user.getId();
                    }

                }else{
                    redirectAttributes.addFlashAttribute("msg", "Can't create a faceset! ");
                    return "redirect:/user/" + user.getId();
                }

            }else{
                //photo is bad
                redirectAttributes.addFlashAttribute("msg", "Can't detect a face! You should use another photo");
                return "redirect:/user/" + user.getId();
            }


            redirectAttributes.addFlashAttribute("msg", "Photo updated successfully!");
            return "redirect:/user/" + user.getId();

        }else{
            redirectAttributes.addFlashAttribute("msg", "Can't upload a photo");
            return "redirect:/user/" + user.getId();
        }



    }



    @RequestMapping(value = { "/regions" }, method = RequestMethod.GET)
    @ResponseBody
    public List<Region> getRegions(@RequestParam long countryId) {
        return restCountriesService.getRegions(countryId, null);
    }

    @RequestMapping(value = { "/cities" }, method = RequestMethod.GET)
    @ResponseBody
    public List<City> getCities(@RequestParam long countryId, @RequestParam long regionId) {
        return restCountriesService.getCities(countryId, regionId, null);
    }
}

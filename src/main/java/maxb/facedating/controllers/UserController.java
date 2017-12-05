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
import maxb.facedating.validator.UserUpdateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    UserUpdateFormValidator userFormValidator;

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

    @RequestMapping( method = RequestMethod.GET)
    public String myUser(Model model) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String username = ((UserDetails)principal).getUsername();

        User user = userService.findByUsername(username);

        model.addAttribute("profileActive", true);

        if (!model.containsAttribute("userForm")) {
            model.addAttribute("userForm", user);
        }


        Map<String,String> genders = new LinkedHashMap<>();

        genders.put(Gender.values()[0].name(), "---select---");
        genders.put(Gender.values()[1].name(), "Male");
        genders.put(Gender.values()[2].name(), "Female");
        genders.put(Gender.values()[3].name(), "Other");

        model.addAttribute("genderEnum", genders);


        if(user.getCountryId() == 0){
            model.addAttribute("hasCountry", false);
        }else{
            model.addAttribute("hasCountry", true);


            if(user.getRegionId() == 0){
                model.addAttribute("hasRegion", false);
            }else{
                model.addAttribute("hasRegion", true);

                List<Region> regionsList = restCountriesService.getRegions(user.getCountryId(), null);

                Map<Long,String> regionsMap = new LinkedHashMap<>();

                for(Region region : regionsList){
                    regionsMap.put(region.getId(), region.getTitle());
                }

                model.addAttribute("regions", regionsMap);

                if(user.getCityId() == 0){
                    model.addAttribute("hasCity", false);
                }else{
                    model.addAttribute("hasCity", true);

                    List<City> citiesList = restCountriesService.getCities(user.getCountryId(), user.getRegionId(), null);

                    Map<Long,String> citiesMap = new LinkedHashMap<>();

                    for(City city : citiesList){
                        citiesMap.put(city.getId(), city.getTitle());
                    }
                    model.addAttribute("cities", citiesMap);
                }
            }



        }





        List<Country> countriesList = restCountriesService.getCountries();

        Map<Long,String> countryMap = new LinkedHashMap<>();

        for(Country country : countriesList){
            countryMap.put(country.getId(), country.getTitle());
        }

        model.addAttribute("countries", countryMap);

        model.addAttribute("userPhotoUrl", user.getPhotoUrl());


        return "user/user";
    }



    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("user") @Validated  User user,
                                BindingResult result, RedirectAttributes redirectAttributes) throws IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User oldUser = userService.findByUsername(userDetails.getUsername());

            if (result.hasErrors()) {

                redirectAttributes.addFlashAttribute("msg", "There are a few errors!");
                redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userForm", result);
                redirectAttributes.addFlashAttribute("userForm", user);
                return "redirect:/user";
            } else {

                oldUser.setFirstName(user.getFirstName());
                oldUser.setLastName(user.getLastName());
                oldUser.setBirthdate(user.getBirthdate());
                oldUser.setAbout(user.getAbout());
                oldUser.setGender(user.getGender());
                oldUser.setCityId(user.getCityId());
                oldUser.setCountryId(user.getCountryId());
                oldUser.setRegionId(user.getRegionId());
                oldUser.setProfession(user.getProfession());
                oldUser.setJob(user.getJob());
                oldUser.setPhoneNumber(user.getPhoneNumber());

                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");

                userService.update(oldUser);

                //User saved = userService.findByUserId(oldUser.getId());

                return "redirect:/user/";

            }
        }

        return "redirect:/user";
    }

    @RequestMapping(value = "/updatePhoto", method = RequestMethod.POST)
    public String updatePhoto(@RequestParam("inputFile") MultipartFile inputFile,
                              RedirectAttributes redirectAttributes) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());

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
                            return "redirect:/user/";
                        }

                    }else{
                        redirectAttributes.addFlashAttribute("msg", "Can't create a faceset! ");
                        return "redirect:/user/";
                    }

                }else{
                    redirectAttributes.addFlashAttribute("msg", "Can't detect a face! You should use another photo");
                    return "redirect:/user/";
                }

                redirectAttributes.addFlashAttribute("msg", "Photo updated successfully!");
                return "redirect:/user/";

            }else{
                redirectAttributes.addFlashAttribute("msg", "Can't upload a photo");
                return "redirect:/user/";
            }
        }


        return "redirect:/user";
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

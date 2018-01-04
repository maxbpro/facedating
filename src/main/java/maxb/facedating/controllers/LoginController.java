package maxb.facedating.controllers;

import maxb.facedating.aws.AwsS3Service;
import maxb.facedating.dao.UserRepository;
import maxb.facedating.domain.Feedback;
import maxb.facedating.domain.User;
import maxb.facedating.domain.enums.Gender;
import maxb.facedating.domain.rest.FacePlusResult;
import maxb.facedating.faceplus.FacePlusService;
import maxb.facedating.geo.RestCountriesService;
import maxb.facedating.geo.model.Country;
import maxb.facedating.service.UserService;
import maxb.facedating.validator.UserRegisterFormValidator;
import maxb.facedating.validator.UserUpdateFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by MaxB on 11/11/2017.
 */
@Controller
@RequestMapping("/")
public class LoginController {


    @Autowired
    UserService userService;

    @Autowired
    AwsS3Service awsS3Service;

    @Autowired
    FacePlusService facePlusService;

    @Autowired
    private RestCountriesService restCountriesService;


    @Autowired
    UserRegisterFormValidator userFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields(new String[]{"inputFile"});
        binder.setValidator(userFormValidator);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Date.class, "birthdate", new CustomDateEditor(dateFormatter, true));
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginForm(@RequestParam(value = "error", required = false) String error,
                                     RedirectAttributes redirectAttributes) throws IOException {


        if(error != null){
            ModelAndView modelAndView = new ModelAndView(new RedirectView("/login#signin", true));
            redirectAttributes.addFlashAttribute("error", "Your username and password is invalid.");
            //modelAndView.addObject("feedbackModel", new Feedback());
            return modelAndView;
        }

        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("feedbackModel", new Feedback());

        return modelAndView;


    }


    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/home";
    }

    @RequestMapping(value = {"/accessDenied"}, method = RequestMethod.GET)
    public ModelAndView accessDenied(){

        ModelAndView modelAndView = new ModelAndView("errors/access_denied");

        return modelAndView;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {


        if (!model.containsAttribute("userForm")) {
            model.addAttribute("userForm", new User());
        }

        Map<String,String> genders = new LinkedHashMap<>();

        genders.put(Gender.values()[0].name(), "---select---");
        genders.put(Gender.values()[1].name(), "Male");
        genders.put(Gender.values()[2].name(), "Female");
        genders.put(Gender.values()[3].name(), "Other");

        model.addAttribute("genderEnum", genders);

        List<Country> countriesList = restCountriesService.getCountries();

        Map<Long,String> countryMap = new LinkedHashMap<>();

        for(Country country : countriesList){
            countryMap.put(country.getId(), country.getTitle());
        }

        model.addAttribute("countries", countryMap);
        model.addAttribute("profileActive", true);

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerNewUser(@ModelAttribute("userForm") @Validated User user, BindingResult result,
                                  @RequestParam("inputFile") MultipartFile inputFile,
                                  Model model, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            redirectAttributes.addFlashAttribute("msg", "There are a few errors!");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userForm", result);
            redirectAttributes.addFlashAttribute("userForm", user);
            return "redirect:/register";

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
                            redirectAttributes.addFlashAttribute("userForm", user);
                            return "redirect:/register";
                        }

                    }else{
                        redirectAttributes.addFlashAttribute("msg", "Can't create a faceset! ");
                        redirectAttributes.addFlashAttribute("userForm", user);
                        return "redirect:/register";
                    }

                    //List<User> userList = userService.listUsers();

                    redirectAttributes.addFlashAttribute("msg", "User added successfully!");

                }else{
                    //photo is bad
                    redirectAttributes.addFlashAttribute("msg", "Can't detect a face! You should use another photo");
                    redirectAttributes.addFlashAttribute("userForm", user);
                    return "redirect:/register";
                }



                return "redirect:/user";

            }else{
                redirectAttributes.addFlashAttribute("msg", "Can't upload a photo");
                redirectAttributes.addFlashAttribute("userForm", user);
                return "redirect:/register";
            }



        }


    }



    @RequestMapping(value = "/login/feedback", method = RequestMethod.POST)
    public ModelAndView feedback(@ModelAttribute("feedbackModel") Feedback feedback, BindingResult result,
                                  Model model, RedirectAttributes redirectAttributes) {


        ModelAndView modelAndView = new ModelAndView(new RedirectView("/login#contact", true));
        redirectAttributes.addFlashAttribute("result", "Feedback has sent");
        return modelAndView;


    }



}

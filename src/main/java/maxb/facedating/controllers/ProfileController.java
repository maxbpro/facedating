package maxb.facedating.controllers;


import maxb.facedating.domain.LikeInfo;
import maxb.facedating.domain.User;
import maxb.facedating.geo.RestCountriesService;
import maxb.facedating.geo.model.City;
import maxb.facedating.geo.model.Country;
import maxb.facedating.service.LikeInfoService;
import maxb.facedating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;


/**
 * Created by MaxB on 25/11/2017.
 */
@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private RestCountriesService restCountriesService;

    @Autowired
    private UserService userService;

    @Autowired
    private LikeInfoService likeInfoService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView profile(@PathVariable long userId, Model model) throws IOException {

        ModelAndView modelAndView = new ModelAndView("user/profile");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());
            User otherUser = userService.findByUserId(userId);

            modelAndView.addObject("senderId", otherUser.getId());

            LikeInfo likeInfo = likeInfoService.findByUserIdAndOtherUserId(user.getId(), otherUser.getId());

            if(likeInfo == null){
                modelAndView.addObject("isLiked", false);
            }else{
                modelAndView.addObject("isLiked", true);
                modelAndView.addObject("likedId", likeInfo.getId());

            }

            modelAndView.addObject("name", otherUser.getFirstName() + " " + otherUser.getLastName() );
            modelAndView.addObject("username", otherUser.getUsername() );
            modelAndView.addObject("photoUrl", otherUser.getPhotoUrl() );
            modelAndView.addObject("about", otherUser.getAbout() );
            modelAndView.addObject("profession", otherUser.getProfession() );
            modelAndView.addObject("phoneNumber", otherUser.getPhoneNumber() );
            modelAndView.addObject("gender", otherUser.getGender() );
            modelAndView.addObject("email", otherUser.getEmail() );
            modelAndView.addObject("birthdate", otherUser.getBirthdate() );
            modelAndView.addObject("job", otherUser.getJob() );


            if(otherUser.getCityId() != 0){
                City city = restCountriesService.getCityById(otherUser.getCityId());
                modelAndView.addObject("city", city.getTitle());
            }else{
                modelAndView.addObject("city", "unknown");
            }

            if(otherUser.getCountryId() != 0){
                Country country = restCountriesService.getCountryById(otherUser.getCountryId());
                modelAndView.addObject("country", country.getTitle());
            }else{
                modelAndView.addObject("country", "unknown");
            }

            modelAndView.addObject("searchActive", true);
        }



        return modelAndView;
    }

    @RequestMapping(value = "/removeLike/{otherUserId}", method = RequestMethod.GET)
    public String deleteLike(@PathVariable Long otherUserId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());

            LikeInfo likeInfo = likeInfoService.findByUserIdAndOtherUserId(user.getId(), otherUserId);

            if(likeInfo != null){
                likeInfoService.delete(likeInfo);
            }
        }

        return "redirect:/profile/" + otherUserId;
    }

    @RequestMapping(value = "/addLike/{otherUserId}", method = RequestMethod.GET)
    public String addLike(@PathVariable Long otherUserId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());

            LikeInfo likeInfo = new LikeInfo();
            likeInfo.setCreatedAt(new Date());
            likeInfo.setUserId(user.getId());
            likeInfo.setOtherUserId(otherUserId);

            likeInfoService.save(likeInfo);
        }

        return "redirect:/profile/" + otherUserId;
    }
}

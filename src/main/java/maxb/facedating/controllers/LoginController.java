package maxb.facedating.controllers;

import maxb.facedating.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by MaxB on 11/11/2017.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginForm(@RequestParam(value = "error", required = false) String error) throws IOException {

        ModelAndView modelAndView = new ModelAndView("login");

        if(error != null){
            modelAndView.addObject("error", "Your username and password is invalid.");
        }

        return modelAndView;
    }


    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "redirect:/logout";
    }

    @RequestMapping(value = {"/accessDenied"}, method = RequestMethod.GET)
    public ModelAndView accessDenied(){

        ModelAndView modelAndView = new ModelAndView("errors/access_denied");

        return modelAndView;
    }



}

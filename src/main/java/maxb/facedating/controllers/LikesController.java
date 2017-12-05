package maxb.facedating.controllers;

import maxb.facedating.domain.CompareInfo;
import maxb.facedating.domain.LikeInfo;
import maxb.facedating.domain.User;
import maxb.facedating.service.LikeInfoService;
import maxb.facedating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MaxB on 25/11/2017.
 */
@Controller
@RequestMapping("/likes")
public class LikesController {

    @Autowired
    private LikeInfoService likeInfoService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String likes(Model model) {

        model.addAttribute("likesActive", true);
        return "likes/likes";
    }





}

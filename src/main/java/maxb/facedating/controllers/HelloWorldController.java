package maxb.facedating.controllers;

import maxb.facedating.aws.AwsS3Service;
import maxb.facedating.domain.User;
import maxb.facedating.faceplus.FacePlusService;
import maxb.facedating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

/**
 * Created by MaxB on 06/11/2017.
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    UserService userService;

    @Autowired
    AwsS3Service awsS3Service;

    @Autowired
    FacePlusService facePlusService;

    @RequestMapping(method = RequestMethod.GET)
    public String sayHello(ModelMap model) throws IOException {

        //List<User> userList = userService.listUsers();
        //model.addAttribute("userList", userList);
        model.addAttribute("greeting", "Hello World from Spring 4 MVC");

        Page<User> page = userService.getUser(1);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("pageInfo", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);


        //facePlusService.addFaceIntoFaceset("c7dc746886a56f613e346e273b0a6eec", "60d8606f8cb261dc33ba27d4e0e4434e");
        //facePlusService.detect("https://s3-ap-southeast-1.amazonaws.com/maxb.faces/maxb2009_1");

        return "welcome";
    }

    @RequestMapping(value = "helloagain", method = RequestMethod.GET)
    public String sayHelloAgain(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "welcome";
    }



    @RequestMapping(value = "/pages/{pageNumber}", method = RequestMethod.GET)
    public String getUserListPage(@PathVariable Integer pageNumber, Model model) {
        Page<User> page = userService.getUser(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("pageInfo", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);

        return "welcome";
    }

}

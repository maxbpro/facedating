package maxb.facedating.controllers;

import maxb.facedating.domain.User;
import maxb.facedating.domain.rest.FacePlusResult;
import maxb.facedating.domain.rest.FaceSearchItem;
import maxb.facedating.domain.rest.FaceSearchResult;
import maxb.facedating.domain.rest.FacesetInfo;
import maxb.facedating.faceplus.FacePlusService;
import maxb.facedating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by MaxB on 13/11/2017.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private FacePlusService facePlusService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(Model model) throws IOException {

        ModelAndView modelAndView = new ModelAndView("home/home");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails)auth.getPrincipal();

            User user = userService.findByUsername(userDetails.getUsername());
            String faceToken = user.getFaceToken();

            FacePlusResult facesetList = facePlusService.getFacesetList(1);
            FacesetInfo[] facesets = facesetList.getFacesets();
            String facesetToken = facesets[0].getFacesetToken();

            FaceSearchResult searchResult = facePlusService.search(faceToken, facesetToken);
        }

        return modelAndView;
    }


    @RequestMapping(value = "/{userId}/search", method = RequestMethod.GET)
    public List<User> search(@PathVariable("userId") long userId){

        List<User> simularUsersList = new ArrayList<>();

        User user = userService.findByUserId(userId);

        FacePlusResult result = facePlusService.getFacesetList(1);
        FacesetInfo[] facesets = result.getFacesets();

//        for(FacesetInfo facesetInfo : facesets){
//
//            FaceSearchResult searchResult = facePlusService.search(user.getFaceToken(),
//                    facesetInfo.getFacesetToken());
//
//            FaceSearchItem[] searchItems = searchResult.getResults();
//
//
//            for(FaceSearchItem item : searchItems){
//
//                if(item.getConfidence() > 20){
//
//                    String faceToken = item.getFace_token();
//                    String username = facesetInfo.getDisplayName();
//
//                    break;
//                }
//            }
//
//        }

        List<FaceSearchItem> listOfResponses =  Arrays.asList(facesets).stream()
                .parallel().map(new Function<FacesetInfo, FaceSearchItem>() {
            @Override
            public FaceSearchItem apply(FacesetInfo facesetInfo) {

                FaceSearchResult searchResult = facePlusService.search(user.getFaceToken(), facesetInfo.getFacesetToken());
                FaceSearchItem[] searchItems = searchResult.getResults();
                FaceSearchItem searchItem = searchItems[0];
                searchItem.setFacesetName(facesetInfo.getDisplayName());
                return searchItem;
            }
        }).collect(Collectors.toList());


        simularUsersList = listOfResponses.stream().map(new Function<FaceSearchItem, User>() {

            @Override
            public User apply(FaceSearchItem faceSearchItem) {
                String username = faceSearchItem.getFacesetName();
                User user = userService.findByUsername(username);
                return user;
            }
        }).collect(Collectors.toList());


        return simularUsersList;
    }
}

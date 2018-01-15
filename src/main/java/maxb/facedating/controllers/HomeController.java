package maxb.facedating.controllers;

import maxb.facedating.configuration.Scheduler;
import maxb.facedating.domain.User;
import maxb.facedating.domain.CompareInfo;
import maxb.facedating.domain.enums.Gender;
import maxb.facedating.domain.rest.FacePlusResult;
import maxb.facedating.domain.rest.FaceSearchResult;
import maxb.facedating.domain.rest.FacesetInfo;
import maxb.facedating.faceplus.FacePlusService;
import maxb.facedating.service.CompareInfoService;
import maxb.facedating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private CompareInfoService compareInfoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(Model model) throws IOException {

        ModelAndView modelAndView = new ModelAndView("home/home");
        modelAndView.addObject("searchActive", true);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails)auth.getPrincipal();

            User user = userService.findByUsername(userDetails.getUsername());
            String faceToken = user.getFaceToken();

            FacePlusResult facesetList = facePlusService.getFacesetList(1);
            FacesetInfo[] facesets = facesetList.getFacesets();
            String facesetToken = facesets[0].getFacesetToken();

            FaceSearchResult searchResult = facePlusService.search(faceToken, facesetToken);



            Map<String,String> genders = new LinkedHashMap<>();

            genders.put(Gender.values()[0].name(), "---select---");
            genders.put(Gender.values()[1].name(), "Male");
            genders.put(Gender.values()[2].name(), "Female");
            genders.put(Gender.values()[3].name(), "Other");

            model.addAttribute("genderEnum", genders);

        }

        //scheduler.startChecking();

        return modelAndView;
    }

    @RequestMapping(value = { "/compares/{pageNumber}" }, method = RequestMethod.GET)
    public ModelAndView getCompares(@PathVariable Integer pageNumber) {

        ModelAndView modelAndView = new ModelAndView("fragments/person_card");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){

            UserDetails userDetails = (UserDetails)auth.getPrincipal();

            User user = userService.findByUsername(userDetails.getUsername());

            Page<CompareInfo> compareInfos = compareInfoService.findByUserFaceTokenAndValueGreaterThanEqual(user.getFaceToken(),
                    75,
                    new PageRequest(pageNumber, 1, new Sort(Sort.Direction.DESC, "value")));

            List<CompareInfo> compareInfoList = compareInfos.getContent();

            if(compareInfoList.size() > 0){

                CompareInfo compareInfo = compareInfoList.get(0);
                User otherUser = userService.findByFacesetTokenAndFaceToken(compareInfo.getFacesetToken(), compareInfo.getFaceToken());

                modelAndView.addObject("userName", otherUser.getFirstName() + " " + otherUser.getLastName());
            }

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

//        List<FaceSearchItem> listOfResponses =  Arrays.asList(facesets).stream()
//                .parallel().map(new Function<FacesetInfo, FaceSearchItem>() {
//            @Override
//            public FaceSearchItem apply(FacesetInfo facesetInfo) {
//
//                FaceSearchResult searchResult = facePlusService.search(user.getFaceToken(), facesetInfo.getFacesetToken());
//                FaceSearchItem[] searchItems = searchResult.getResults();
//                FaceSearchItem searchItem = searchItems[0];
//                searchItem.setFacesetName(facesetInfo.getDisplayName());
//                return searchItem;
//            }
//        }).collect(Collectors.toList());
//
//
//        simularUsersList = listOfResponses.stream().map(new Function<FaceSearchItem, User>() {
//
//            @Override
//            public User apply(FaceSearchItem faceSearchItem) {
//                String username = faceSearchItem.getFacesetName();
//                User user = userService.findByUsername(username);
//                return user;
//            }
//        }).collect(Collectors.toList());




        return simularUsersList;
    }
}

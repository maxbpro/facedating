package maxb.facedating.configuration;

import maxb.facedating.domain.User;
import maxb.facedating.domain.CompareInfo;
import maxb.facedating.domain.rest.FacePlusResult;
import maxb.facedating.domain.rest.FaceSearchItem;
import maxb.facedating.domain.rest.FaceSearchResult;
import maxb.facedating.domain.rest.FacesetInfo;
import maxb.facedating.faceplus.FacePlusService;
import maxb.facedating.service.CompareInfoService;
import maxb.facedating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MaxB on 27/11/2017.
 */
@Configuration
@EnableScheduling
@Component
public class Scheduler {

    @Autowired
    private UserService userService;

    @Autowired
    private FacePlusService facePlusService;

    @Autowired
    private CompareInfoService compareInfoService;

    @Scheduled(fixedDelay = 900000) // 15 min
    public void executeEveryOneMin() {
        System.out.println("Run Job " + new Date());
        //startChecking();
    }

    public void startChecking(){

        System.out.println("Job started" + new Date());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        String username = ((UserDetails)principal).getUsername();

        User user = userService.findByUsername(username);

        FacePlusResult result = facePlusService.getFacesetList(1);
        FacesetInfo[] facesets = result.getFacesets();

        List<CompareInfo> compares =  Arrays.asList(facesets).stream()
                .map(facesetInfo -> {

                    FaceSearchResult searchResult = facePlusService.search(user.getFaceToken(), facesetInfo.getFacesetToken());
                    FaceSearchItem[] searchItems = searchResult.getResults();
                    FaceSearchItem searchItem = searchItems[0];

                    CompareInfo compareInfo = new CompareInfo();
                    compareInfo.setUserFaceToken(user.getFaceToken());
                    compareInfo.setFacesetToken(facesetInfo.getFacesetToken());
                    compareInfo.setFaceToken(searchItem.getFace_token());
                    compareInfo.setValue(searchItem.getConfidence());

                    compareInfoService.save(compareInfo);

                    return compareInfo;

                }).collect(Collectors.toList());


        List<CompareInfo> compareInfos = compareInfoService.listCompares();
        CompareInfo compareInfo = compareInfos.get(0);

        System.out.println("Job finished" + new Date());
        System.out.println("compareInfos: " + compareInfos);
    }
}

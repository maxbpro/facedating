package maxb.facedating.rest;

import maxb.facedating.domain.CompareInfo;
import maxb.facedating.domain.LikeInfo;
import maxb.facedating.domain.User;
import maxb.facedating.rest.dto.CompareDTO;
import maxb.facedating.rest.dto.LikeDTO;
import maxb.facedating.service.CompareInfoService;
import maxb.facedating.service.LikeInfoService;
import maxb.facedating.service.UserService;
import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController()
@RequestMapping("rest/compares")
public class ComparesController {

    @Autowired
    private CompareInfoService compareInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping(value = { "/{pageNumber}" }, method = RequestMethod.GET)
    public ResponseEntity<CompareDTO> getCompares(@PathVariable Integer pageNumber) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){

            UserDetails userDetails = (UserDetails)auth.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());

            Page<CompareInfo> compareInfoPage = compareInfoService.findByUserFaceTokenAndValueGreaterThanEqual(user.getFaceToken(), 70,
                    new PageRequest(pageNumber, 1, new Sort(Sort.Direction.DESC, "value")));


            if(compareInfoPage.getContent().size() > 0){

                CompareInfo compareInfo = compareInfoPage.getContent().get(0);

                User otherUser = userService.findByFacesetTokenAndFaceToken(
                        compareInfo.getFacesetToken(),
                        compareInfo.getFaceToken());

                CompareDTO compareDTO = new CompareDTO();
                compareDTO.setId(compareInfo.getId());
                compareDTO.setUserId(otherUser.getId());
                compareDTO.setUserPhotoUrl(otherUser.getPhotoUrl());
                compareDTO.setUserFirstName(otherUser.getFirstName());
                compareDTO.setUserLastName(otherUser.getLastName());
                compareDTO.setUsername(otherUser.getUsername());
                compareDTO.setUserAbout(otherUser.getAbout());
                compareDTO.setUserProfession(otherUser.getProfession());
                compareDTO.setUserBirthdate(otherUser.getBirthdate());

                return new ResponseEntity<>(compareDTO, HttpStatus.OK);

            }else{
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }



        }


        return new ResponseEntity(HttpStatus.UNAUTHORIZED);

    }



}

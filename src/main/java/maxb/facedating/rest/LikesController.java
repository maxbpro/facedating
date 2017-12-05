package maxb.facedating.rest;

import maxb.facedating.domain.LikeInfo;
import maxb.facedating.domain.User;
import maxb.facedating.rest.dto.LikeDTO;
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

@RestController("LikesRestController")
@RequestMapping("rest/likes")
public class LikesController {

    @Autowired
    private LikeInfoService likeInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


    @RequestMapping(value = { "/{pageNumber}" }, method = RequestMethod.GET)
    public List<LikeDTO> getLikes(@PathVariable Integer pageNumber) {

        List<LikeDTO> result = new ArrayList<>();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)){

            UserDetails userDetails = (UserDetails)auth.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());

            Page<LikeInfo> likeInfos = likeInfoService.findByUserId(user.getId(),
                    new PageRequest(pageNumber, 6, new Sort(Sort.Direction.DESC, "createdAt")));

            List<LikeInfo> likesInfoList = likeInfos.getContent();

            for(LikeInfo likeInfo: likesInfoList){

                User otherUser = userService.findByUserId(likeInfo.getOtherUserId());

                LikeDTO likeDTO = new LikeDTO();
                likeDTO.setId(likeInfo.getId());
                likeDTO.setCreatedAt(likeInfo.getCreatedAt());
                likeDTO.setUserId(otherUser.getId());
                likeDTO.setUserFirstName(otherUser.getFirstName());
                likeDTO.setUserLastName(otherUser.getLastName());
                likeDTO.setUserPhotoUrl(otherUser.getPhotoUrl());
                likeDTO.setUserAbout(otherUser.getAbout());
                likeDTO.setUserProfession(otherUser.getProfession());
                likeDTO.setUserBirthdate(otherUser.getBirthdate());

                result.add(likeDTO);
            }

        }


        return result;

    }


    @RequestMapping(value = { "/{likeId}" }, method = RequestMethod.DELETE)
    public ResponseEntity deleteLike(@PathVariable("likeId") Long id) {
        likeInfoService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LikeInfo> addLike(@RequestParam("otherUserId") Long otherUserId) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());

            LikeInfo likeInfo = new LikeInfo();
            likeInfo.setCreatedAt(new Date());
            likeInfo.setUserId(user.getId());
            likeInfo.setOtherUserId(otherUserId);

            likeInfoService.save(likeInfo);
            return new ResponseEntity<>(likeInfo, HttpStatus.CREATED);
        }

        return new ResponseEntity(HttpStatus.UNAUTHORIZED);

    }
}

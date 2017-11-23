package maxb.facedating.faceplus.impl;

import maxb.facedating.domain.rest.*;
import maxb.facedating.faceplus.FacePlusService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * Created by MaxB on 09/11/2017.
 */
@Service
public class FacePlusServiceImpl implements FacePlusService {

    @Value("${face_plus_api_key}")
    private String api_key;

    @Value("${face_plus_api_secret}")
    private String api_secret;

    @Value("${face_plus_resource_url_analyze}")
    private String resource_url_analyze;

    @Value("${face_plus_resource_url_detect}")
    private String resource_url_detect;

    @Value("${face_plus_resource_url_search}")
    private String resource_url_search;

    //Facessets
    @Value("${face_plus_resource_url_faceset_create}")
    private String resource_url_faceset_create;

    @Value("${face_plus_resource_url_faceset_delete}")
    private String resource_url_faceset_delete;

    @Value("${face_plus_resource_url_faceset_update}")
    private String resource_url_faceset_update;


    @Value("${face_plus_resource_url_faceset_getfacesets}")
    private String resource_url_faceset_getfacesets;

    @Value("${face_plus_resource_url_faceset_getdetail}")
    private String resource_url_faceset_getdetail;

    //Faces
    @Value("${face_plus_resource_url_faceset_addface}")
    private String resource_url_faceset_addface;

    @Value("${face_plus_resource_url_faceset_removeface}")
    private String resource_url_faceset_removeface;


    @Override
    public FacePlusResult getFacesetList(int start) {

        HttpHeaders headers = getHeaders();

        //returns 100 facesets
        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("start", String.valueOf(start));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FacePlusResult> response = restTemplate.postForEntity(resource_url_faceset_getfacesets, request , FacePlusResult.class );

        return response.getBody();
    }

    @Override
    public FacesetDetails getFacesetDetails(String facesetToken, int start) {

        HttpHeaders headers = getHeaders();

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("start", String.valueOf(start));
        map.add("faceset_token", facesetToken);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FacesetDetails> response = restTemplate.postForEntity( resource_url_faceset_getdetail, request , FacesetDetails.class );

        return response.getBody();
    }



    @Override
    public FacePlusResult createFaceset(String displayName, String userData, String tags) {

        HttpHeaders headers = getHeaders();

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("display_name", displayName);
        map.add("user_data", userData);
        map.add("tags", tags);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FacePlusResult> response = restTemplate.postForEntity( resource_url_faceset_create, request , FacePlusResult.class );

        return response.getBody();
    }

    @Override
    public FacePlusResult updateFaceset(String faceset_token, String displayName, String userData, String tags) {

        HttpHeaders headers = getHeaders();

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("faceset_token", faceset_token);
        map.add("display_name", displayName);
        map.add("user_data", userData);
        map.add("tags", tags);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FacePlusResult> response = restTemplate.postForEntity( resource_url_faceset_update, request , FacePlusResult.class );

        return response.getBody();
    }

    @Override
    public FacePlusResult deleteFaceset(String faceset_token) {

        HttpHeaders headers = getHeaders();

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("faceset_token", faceset_token);
        map.add("check_empty", "0");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FacePlusResult> response = restTemplate.postForEntity( resource_url_faceset_delete, request , FacePlusResult.class );

        return response.getBody();
    }

    @Override
    public FacePlusResult addFaceIntoFaceset(String faceset_token, String face_token) {

        HttpHeaders headers = getHeaders();

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("faceset_token", faceset_token);
        map.add("face_tokens", face_token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FacePlusResult> response = restTemplate.postForEntity( resource_url_faceset_addface, request , FacePlusResult.class );

        return response.getBody();
    }

    @Override
    public FacePlusResult removeFaceFromFaceset(String faceset_token, String face_token) {

        HttpHeaders headers = getHeaders();
        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("faceset_token", faceset_token);
        map.add("face_tokens", face_token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FacePlusResult> response = restTemplate.postForEntity(resource_url_faceset_removeface, request , FacePlusResult.class );

        return response.getBody();
    }

    @Override
    public String detect(String imageUrl){

        HttpHeaders headers = getHeaders();

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("image_url", imageUrl);
        map.add("return_landmark", "2");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FaceAnalyzed> response = restTemplate.postForEntity( resource_url_detect, request , FaceAnalyzed.class );

        FaceAnalyzed faceAnalyzed = response.getBody();
        FaceInfo[] facesArray = faceAnalyzed.getFacesArray();

        if(facesArray.length > 0){
            return facesArray[0].getFaceToken();
        }

        return null;
    }

    @Override
    public void analyze(){

        HttpHeaders headers = getHeaders();

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("face_tokens", "");
        map.add("return_landmark", "2");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FaceAnalyzed> response = restTemplate.postForEntity( resource_url_analyze, request , FaceAnalyzed.class );

        FaceAnalyzed faceAnalyzed = response.getBody();

    }

    @Override
    public FaceSearchResult search(String face_token, String faceset_token) {

        HttpHeaders headers = getHeaders();

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("face_token", face_token);
        map.add("faceset_token", faceset_token);
        map.add("return_result_count", "5");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<FaceSearchResult> response = restTemplate.postForEntity( resource_url_search, request , FaceSearchResult.class );

        return response.getBody();
    }

    private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }


    private MultiValueMap<String, String> getMultiValueMap(){

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("api_key", api_key);
        map.add("api_secret", api_secret);

        return map;
    }
}

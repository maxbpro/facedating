package maxb.facedating.faceplus;

import maxb.facedating.domain.rest.FacePlusResult;
import maxb.facedating.domain.rest.FaceSearchResult;
import maxb.facedating.domain.rest.FacesetDetails;

/**
 * Created by MaxB on 09/11/2017.
 */
public interface FacePlusService {

    FacePlusResult createFaceset(String displayName, String userData, String tags);
    FacePlusResult updateFaceset(String faceset_token, String displayName, String userData, String tags);
    FacePlusResult deleteFaceset(String faceset_token);

    FacePlusResult addFaceIntoFaceset(String faceset_token, String face_token);
    FacePlusResult removeFaceFromFaceset(String faceset_token, String face_token);

    FacePlusResult getFacesetList(int start);

    FacesetDetails getFacesetDetails(String facesetToken, int start);

    String detect(String imageUrl);
    void analyze();

    FaceSearchResult search(String face_token, String faceset_token);
}

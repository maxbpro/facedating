package maxb.facedating.domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by MaxB on 09/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceInfo implements Serializable {

    @JsonProperty("face_token")
    private String faceToken;

    //private landmark

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }
}

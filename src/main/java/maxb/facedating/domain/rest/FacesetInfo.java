package maxb.facedating.domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by MaxB on 10/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacesetInfo implements Serializable {

    @JsonProperty("faceset_token")
    private String facesetToken;

    @JsonProperty("display_name")
    private String displayName;


    public String getFacesetToken() {
        return facesetToken;
    }

    public void setFacesetToken(String facesetToken) {
        this.facesetToken = facesetToken;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}

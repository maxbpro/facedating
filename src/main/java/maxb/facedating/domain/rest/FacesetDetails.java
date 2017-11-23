package maxb.facedating.domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by MaxB on 10/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacesetDetails implements Serializable {

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("faceset_token")
    private String facesetToken;

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("user_data")
    private String userData;


    @JsonProperty("face_count")
    private int faceCount;

    @JsonProperty("face_tokens")
    private String[] faceTokens;

    @JsonProperty("next")
    private String next;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

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

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public int getFaceCount() {
        return faceCount;
    }

    public void setFaceCount(int faceCount) {
        this.faceCount = faceCount;
    }

    public String[] getFaceTokens() {
        return faceTokens;
    }

    public void setFaceTokens(String[] faceTokens) {
        this.faceTokens = faceTokens;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}

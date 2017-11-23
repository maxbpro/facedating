package maxb.facedating.domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by MaxB on 10/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FacePlusResult implements Serializable {

    //failure_detail -> array
//    The face_token failed to added into FaceSet and the failure reason
//    reason: the failure reason, including the follows:
//    INVALID_FACE_TOKEN: face_token not found;
//    QUOTA_EXCEEDED: the limitation of FaceSet storage reached

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("faceset_token")
    private String facesetToken;


    @JsonProperty("time_used")
    private int timeUsed;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("next")
    private String next;

    @JsonProperty("facesets")
    private FacesetInfo[] facesets;

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


    public int getTimeUsed() {
        return timeUsed;
    }

    public void setTimeUsed(int timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public FacesetInfo[] getFacesets() {
        return facesets;
    }

    public void setFacesets(FacesetInfo[] facesets) {
        this.facesets = facesets;
    }
}

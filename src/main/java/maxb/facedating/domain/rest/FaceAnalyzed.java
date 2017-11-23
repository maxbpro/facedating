package maxb.facedating.domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by MaxB on 09/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceAnalyzed implements Serializable {

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("time_used")
    private int timeUsed;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("faces")
    private FaceInfo[] facesArray;


    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public FaceInfo[] getFacesArray() {
        return facesArray;
    }

    public void setFacesArray(FaceInfo[] facesArray) {
        this.facesArray = facesArray;
    }
}

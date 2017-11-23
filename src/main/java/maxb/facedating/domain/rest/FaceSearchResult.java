package maxb.facedating.domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by MaxB on 13/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceSearchResult implements Serializable {

    @JsonProperty("request_id")
    private String requestId;

    @JsonProperty("time_used")
    private int timeUsed;

    @JsonProperty("error_message")
    private String errorMessage;

    @JsonProperty("thresholds")
    private FaceThreshold thresholds;

    @JsonProperty("results")
    private FaceSearchItem[] results;

    @JsonProperty("faces")
    private Object[] faces;

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

    public FaceThreshold getThresholds() {
        return thresholds;
    }

    public void setThresholds(FaceThreshold thresholds) {
        this.thresholds = thresholds;
    }

    public FaceSearchItem[] getResults() {
        return results;
    }

    public void setResults(FaceSearchItem[] results) {
        this.results = results;
    }

    public Object[] getFaces() {
        return faces;
    }

    public void setFaces(Object[] faces) {
        this.faces = faces;
    }
}

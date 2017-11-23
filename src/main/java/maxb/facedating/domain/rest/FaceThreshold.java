package maxb.facedating.domain.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by MaxB on 13/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FaceThreshold implements Serializable {

    @JsonProperty("1e-3")
    private String confidence1e3;

    @JsonProperty("1e-4")
    private String confidence1e4;

    @JsonProperty("1e-5")
    private String confidence1e5;

    public String getConfidence1e3() {
        return confidence1e3;
    }

    public void setConfidence1e3(String confidence1e3) {
        this.confidence1e3 = confidence1e3;
    }

    public String getConfidence1e4() {
        return confidence1e4;
    }

    public void setConfidence1e4(String confidence1e4) {
        this.confidence1e4 = confidence1e4;
    }

    public String getConfidence1e5() {
        return confidence1e5;
    }

    public void setConfidence1e5(String confidence1e5) {
        this.confidence1e5 = confidence1e5;
    }
}

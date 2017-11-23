package maxb.facedating.geo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by MaxB on 14/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VkResponse<T> implements Serializable {

    @JsonProperty("response")
    private T response;


    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}

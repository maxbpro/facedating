package maxb.facedating.geo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by MaxB on 14/11/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Serializable {

    @JsonProperty("title")
    private String title;

    @JsonProperty("id")
    private long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

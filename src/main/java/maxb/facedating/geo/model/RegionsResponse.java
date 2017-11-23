package maxb.facedating.geo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by MaxB on 14/11/2017.
 */
public class RegionsResponse {

    @JsonProperty("count")
    private int count;

    @JsonProperty("items")
    private Region[] regions;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public Region[] getRegions() {
        return regions;
    }

    public void setRegions(Region[] regions) {
        this.regions = regions;
    }
}

package maxb.facedating.geo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by MaxB on 14/11/2017.
 */
public class CitiesResponse {

    @JsonProperty("count")
    private int count;

    @JsonProperty("items")
    private City[] cities;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public City[] getCities() {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }
}

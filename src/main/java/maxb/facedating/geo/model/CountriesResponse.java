package maxb.facedating.geo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by MaxB on 14/11/2017.
 */
public class CountriesResponse {

    @JsonProperty("count")
    private int count;

    @JsonProperty("items")
    private Country[] countries;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public Country[] getCountries() {
        return countries;
    }

    public void setCountries(Country[] countries) {
        this.countries = countries;
    }
}

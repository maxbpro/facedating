package maxb.facedating.geo;

import maxb.facedating.geo.model.City;
import maxb.facedating.geo.model.Country;
import maxb.facedating.geo.model.Region;

import java.util.List;

/**
 * Created by MaxB on 14/11/2017.
 */
public interface RestCountriesService {

    List<Country> getCountries();

    List<Region> getRegions(long country_id, String substring);

    List<City> getCities(long country_id, long region_id, String substring);

    City getCityById(long city_id);

    Country getCountryById(long country_id);
}

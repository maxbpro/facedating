package maxb.facedating.geo.impl;

import maxb.facedating.geo.RestCountriesService;
import maxb.facedating.geo.model.*;
import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by MaxB on 14/11/2017.
 */
@Service
public class RestCountriesServiceImpl implements RestCountriesService {

    @Value("${vk.serverKey}")
    private String serverKey;

    @Value("${vk.version}")
    private String version;

    @Value("${vk.endpoint}")
    private String endpoint;

    @Value("${vk.getCountries}")
    private String urlCountries;

    @Value("${vk.getCities}")
    private String urlCities;

    @Value("${vk.getRegions}")
    private String urlRegions;

    @Value("${vk.getCity}")
    private String urlCity;

    @Value("${vk.getCountry}")
    private String urlCountry;


    @Override
    public List<Country> getCountries() {

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("need_all", "0");
        map.add("count", "100");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, getHeaders());

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<VkResponse<CountriesResponse>> response = restTemplate.exchange(endpoint + urlCountries, HttpMethod.POST,
                request, new ParameterizedTypeReference<VkResponse<CountriesResponse>>() {});

        CountriesResponse countriesResponse = response.getBody().getResponse();

        return new ArrayList<>(Arrays.asList(countriesResponse.getCountries()));
    }

    @Override
    public List<Region> getRegions(long country_id, String substring) {

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("country_id", String.valueOf(country_id));
        map.add("need_all", "1");

        if(substring != null)
            map.add("q", substring);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, getHeaders());

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<VkResponse<RegionsResponse>> response = restTemplate.exchange(endpoint + urlRegions, HttpMethod.POST,
                request, new ParameterizedTypeReference<VkResponse<RegionsResponse>>() {});

        RegionsResponse regionsResponse = response.getBody().getResponse();

        return new ArrayList<>(Arrays.asList(regionsResponse.getRegions()));
    }

    @Override
    public List<City> getCities(long country_id, long region_id, String substring) {

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("region_id", String.valueOf(region_id));
        map.add("country_id", String.valueOf(country_id));
        map.add("need_all", "1");

        if(substring != null)
            map.add("q", substring);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, getHeaders());

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<VkResponse<CitiesResponse>> response = restTemplate.exchange(endpoint + urlCities, HttpMethod.POST,
                request, new ParameterizedTypeReference<VkResponse<CitiesResponse>>() {});

        CitiesResponse citiesResponse = response.getBody().getResponse();

        return new ArrayList<>(Arrays.asList(citiesResponse.getCities()));
    }


    @Override
    public City getCityById(long city_id) {

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("city_ids", String.valueOf(city_id));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, getHeaders());

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<VkResponse<City[]>> response = restTemplate.exchange(endpoint + urlCity, HttpMethod.POST,
                request, new ParameterizedTypeReference<VkResponse<City[]>>() {});

        City city = response.getBody().getResponse()[0];

        return city;
    }

    @Override
    public Country getCountryById(long country_id) {

        MultiValueMap<String, String> map= getMultiValueMap();
        map.add("country_ids", String.valueOf(country_id));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, getHeaders());

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<VkResponse<Country[]>> response = restTemplate.exchange(endpoint + urlCountry, HttpMethod.POST,
                request, new ParameterizedTypeReference<VkResponse<Country[]>>() {});

        Country country  = response.getBody().getResponse()[0];

        return country;
    }

    private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return headers;
    }

    private MultiValueMap<String, String> getMultiValueMap(){

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("v", version);
        map.add("access_token", serverKey);

        return map;
    }

}

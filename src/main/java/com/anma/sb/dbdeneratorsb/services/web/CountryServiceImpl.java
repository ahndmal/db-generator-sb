package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.web.CountryWeb;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private WebClient webClient = WebClient.create();
    private final RestTemplate template = new RestTemplate();
    //https://restcountries.com/v3.1/name/{name}
    //https://restcountries.com/#api-endpoints-v3-name


    private final Environment environment;

    public CountryServiceImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public CountryWeb getByName(String name) {
//        final String URL = environment.getProperty("links.countries.name");
        final String URL = "https://restcountries.com/v3.1/name/";
        return template.getForObject(URL + name, CountryWeb.class);
    }

    @Override
    public CountryWeb getById(int id) {
        return null;
    }


    @Override
    public List<CountryWeb> allCountries() {
        final String URL = environment.getProperty("links.countries");
        return Arrays.asList(template.getForObject(URL, CountryWeb[].class));
    }
}

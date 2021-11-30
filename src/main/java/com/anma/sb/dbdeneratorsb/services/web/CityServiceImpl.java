package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.City;
import com.anma.sb.dbdeneratorsb.models.Country;
import com.anma.sb.dbdeneratorsb.models.web.CityWeb;
import com.anma.sb.dbdeneratorsb.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    private final RestTemplate template = new RestTemplate();
    private WebClient webClient = WebClient.create();
    private final CountryRepo countryRepo;
    private final String URL = "https://restcountries.com/v3.1/capital/";

    @Autowired
    public CityServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public List<CityWeb> allCities() {
        List<CityWeb> cities = new ArrayList<>();
        List<String> capitals = countryRepo.findAll()
                .stream().map(Country::getCapital).collect(Collectors.toList());
        capitals.forEach(cap -> {
            CityWeb city = template.getForObject(URL + cap, CityWeb.class);
            cities.add(city);
        });

        return cities;
    }

    @Override
    public CityWeb cityById() {
        return null;
    }
}

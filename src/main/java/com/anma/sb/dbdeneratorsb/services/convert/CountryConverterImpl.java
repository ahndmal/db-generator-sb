package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Country;
import com.anma.sb.dbdeneratorsb.models.web.CountryWeb;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Random;

@Service
public class CountryConverterImpl implements CountryConverter {

    Logger logger = LoggerFactory.getLogger(CountryConverterImpl.class);

    @Override
    public Country convert(CountryWeb countryWeb) {
        Country country = new Country();
//        country.setId(new Random().nextInt());
        country.setArea(countryWeb.getArea());
        country.setCca2(countryWeb.getCca2());
        country.setIndependent(countryWeb.isIndependent());
        country.setRegion(countryWeb.getRegion());
        country.setUnMember(countryWeb.getUnMember());
        country.setStatus(countryWeb.getStatus());
        country.setCode(countryWeb.getTld()[0]);
        country.setName(countryWeb.getName().getOfficial());
        country.setPopulation(countryWeb.getPopulation());
        if (countryWeb.getCapital() != null) {
            country.setCapital(countryWeb.getCapital()[0]);
        } else country.setCapital("");
//        String continents = Arrays.stream(countryWeb.getContinents()).map(c -> c + "," + c).toString();
        if (countryWeb.getContinents() != null) {
            country.setContinents(String.join(",", countryWeb.getContinents()));
        } else country.setContinents("");
//        country.setLanguages(countryWeb.getLanguages().get()); //todo

//        country.setPersons(countryWeb.);
        logger.info("[ == ] country created:");
        logger.info(country.toString());
        return country;
    }

    @Override
    public CountryWeb convert(Country country) {
        return null;
    }
}

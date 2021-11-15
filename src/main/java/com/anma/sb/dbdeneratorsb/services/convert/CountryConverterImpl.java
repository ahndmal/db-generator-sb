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

        if (countryWeb.getTld() != null) {
            if (countryWeb.getTld()[0] != null && countryWeb.getTld().length > 0) {
                country.setCode(countryWeb.getTld()[0]);
            } else country.setCode("");
        }

        country.setName(countryWeb.getName().getOfficial());
        country.setPopulation(countryWeb.getPopulation());

        if (countryWeb.getCapital() != null) {
            country.setCapital(countryWeb.getCapital()[0]);
        } else country.setCapital("");
//        String continents = Arrays.stream(countryWeb.getContinents()).map(c -> c + "," + c).toString();
        if (countryWeb.getContinents() != null) {
            country.setContinents(String.join(",", countryWeb.getContinents()));
        } else country.setContinents("");

        if (countryWeb.getBorders() != null) {
            country.setBorders(String.join(",", countryWeb.getBorders()));
        } else country.setBorders("");
        if (countryWeb.getLanguages() != null) {
            country.setLanguages(String.join(",", countryWeb.getLanguages().values()));
        } else country.setLanguages("");

        logger.info("[ == ] country created:");
        logger.info(country.toString());
        return country;
    }

    @Override
    public CountryWeb convert(Country country) {
        return null;
    }
}

package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Country;
import com.anma.sb.dbdeneratorsb.models.web.CountryWeb;
import org.springframework.stereotype.Service;

@Service
public class CountryConverterImpl implements CountryConverter {

    @Override
    public Country convert(CountryWeb countryWeb) {
        Country country = new Country();
        country.setId(countryWeb.getId());
        country.setArea(countryWeb.getArea());
        country.setCca2(country.getCca2());
        country.setIndependent(country.isIndependent());
        country.setRegion(country.getRegion());
        country.setUnMember(country.getUnMember());
        country.setStatus(country.getStatus());
//        country.setPersons(countryWeb.p);
        return country;
    }

    @Override
    public CountryWeb convert(Country country) {
        return null;
    }
}

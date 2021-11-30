package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.Country;
import com.anma.sb.dbdeneratorsb.models.web.CountryWeb;

import java.util.List;

public interface CountryService {

    CountryWeb getById(int id);
    CountryWeb getByName(String name);
    List<CountryWeb> allCountries();
}

package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.web.CityWeb;

import java.util.List;

public interface CityService {

    List<CityWeb> allCities();
    CityWeb cityById();
}

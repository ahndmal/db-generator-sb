package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.City;
import com.anma.sb.dbdeneratorsb.models.web.CityWeb;
import org.springframework.stereotype.Service;

@Service
public class CityConverterImpl implements CityConverter {

    @Override
    public City convert(CityWeb cityWeb) {
        City city = new City();
        city.setName(cityWeb.getName());
        city.setCode(cityWeb.getCode());
        city.setContinent(cityWeb.getContinent());
        city.setPopulation(cityWeb.getPopulation());
        return city;
    }

    @Override
    public CityWeb convert(City city) {
        return null;
    }
}

package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.City;
import com.anma.sb.dbdeneratorsb.models.web.CityWeb;

public interface CityConverter {
    City convert(CityWeb cityWeb);
    CityWeb convert(City city);
}

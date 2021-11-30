package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Country;
import com.anma.sb.dbdeneratorsb.models.web.CountryWeb;

public interface CountryConverter {
    Country convert(CountryWeb countryWeb);
    CountryWeb convert(Country country);
}

package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Car;
import com.anma.sb.dbdeneratorsb.models.web.CarWeb;

public interface CarConverter {
    Car convert(CarWeb carWeb);
    CarWeb convert(Car car);
}

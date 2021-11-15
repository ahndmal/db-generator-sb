package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.Car;
import com.anma.sb.dbdeneratorsb.models.web.CarWeb;

public interface CarService {
    Car convert(CarWeb carWeb);
    CarWeb convert(Car car);
}

package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.web.CarWeb;

import java.util.List;

public interface CarService {

    List<CarWeb> alLCars();
    CarWeb carById(long id);

}

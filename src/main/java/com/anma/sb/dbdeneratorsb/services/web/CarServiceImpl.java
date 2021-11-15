package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.Car;
import com.anma.sb.dbdeneratorsb.models.web.CarWeb;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    
    @Override
    public Car convert(CarWeb carWeb) {
        return null;
    }

    @Override
    public CarWeb convert(Car car) {
        return null;
    }
}

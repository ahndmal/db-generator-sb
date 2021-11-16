package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Car;
import com.anma.sb.dbdeneratorsb.models.web.CarWeb;
import com.anma.sb.dbdeneratorsb.repo.PersonRepo;
import com.anma.sb.dbdeneratorsb.services.web.PersonWebService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarConverterImpl implements CarConverter {

    private final PersonWebService personWebService;

    public CarConverterImpl(PersonWebService personWebService) {
        this.personWebService = personWebService;
    }

    @Override
    public Car convert(CarWeb carWeb) {
        return Car.builder()
                .carId(carWeb.getCarId())
                .id(UUID.randomUUID().toString())
                .age(RandomUtils.nextInt(0, 30))
                .countryCodes(carWeb.getCountryCodes())
                .origin(carWeb.getOrigin())
                .color(carWeb.getColor())
                .registry(carWeb.getRegistry())
                .model(carWeb.getBrand())   //brand -> model
                .personId(personWebService.getPersRandomId())
                .build();
    }

    @Override
    public CarWeb convert(Car car) {
        return null;
    }
}

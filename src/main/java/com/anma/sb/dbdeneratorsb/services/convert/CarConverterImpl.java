package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Car;
import com.anma.sb.dbdeneratorsb.models.web.CarWeb;
import com.anma.sb.dbdeneratorsb.services.RandomService;
import com.anma.sb.dbdeneratorsb.services.web.PersonWebService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CarConverterImpl implements CarConverter {

    private final PersonWebService personWebService;
    private final RandomService randomService;

    public CarConverterImpl(PersonWebService personWebService, RandomService randomService) {
        this.personWebService = personWebService;
        this.randomService = randomService;
    }

    @Override
    public Car convert(CarWeb carWeb) {
        return Car.builder()
                .carId(carWeb.getCarId())
                .id(UUID.randomUUID().toString())
                .age(RandomUtils.nextInt(0, 30))
                .model(carWeb.getBrand())   //brand -> model
                .personId(personWebService.getPersRandomId())
                .countryCodes(randomService.getCountryCode()) // empty
                .origin(randomService.getOrigin()) // empty
                .color(randomService.getColor())   // empty
                .registry(carWeb.getRegistry())
                .maxSpeed(randomService.getRandomSpeed())
//                .registry(randomService.getRegistry())
                .build();
    }

    @Override
    public CarWeb convert(Car car) {
        return null;
    }
}

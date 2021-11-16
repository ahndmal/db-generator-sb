package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Car;
import com.anma.sb.dbdeneratorsb.models.web.CarWeb;
import com.anma.sb.dbdeneratorsb.repo.PersonRepo;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarConverterImpl implements CarConverter {

    private final PersonRepo personRepo;

    public CarConverterImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    private List<Long> personIds() {
        personRepo.findAll().stream()
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
                .personId()
                .build();
        List.of(1,2,3).stream().
    }

    @Override
    public CarWeb convert(Car car) {
        return null;
    }
}

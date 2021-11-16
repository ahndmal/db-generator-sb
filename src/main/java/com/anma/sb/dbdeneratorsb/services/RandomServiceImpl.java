package com.anma.sb.dbdeneratorsb.services;

import com.anma.sb.dbdeneratorsb.models.Country;
import com.anma.sb.dbdeneratorsb.repo.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class RandomServiceImpl implements RandomService {

    private final CountryRepo countryRepo;
    private final Random random = new Random();

    @Autowired
    public RandomServiceImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public String getColor() {
        return List.of("green", "red", "pink", "blue", "brown", "black", "yellow", "orange")
                .get(random.nextInt(8));
    }

    @Override
    public String getCountryCode() {
        return countryRepo.findAll().stream()
                .map(Country::getCca2)
                .collect(Collectors.toList())
                .get(random.nextInt(countryRepo.findAll().size()));
    }

    @Override
    public String getOrigin() {
        return countryRepo.findAll().stream()
                .map(Country::getName)
                .collect(Collectors.toList())
                .get(random.nextInt(countryRepo.findAll().size()));
    }

    @Override
    public int getAge(int max) {
        return random.nextInt(max);
    }

    @Override
    public int getRandomSpeed() {
        return random.nextInt(350);
    }

    @Override
    public String getRegistry() {
        return null;
    }
}

package com.anma.sb.dbdeneratorsb;

import com.anma.sb.dbdeneratorsb.models.Car;
import com.anma.sb.dbdeneratorsb.models.Cat;
import com.anma.sb.dbdeneratorsb.models.Country;
import com.anma.sb.dbdeneratorsb.models.Person;
import com.anma.sb.dbdeneratorsb.models.web.CarWeb;
import com.anma.sb.dbdeneratorsb.models.web.CountryWeb;
import com.anma.sb.dbdeneratorsb.repo.CarRepo;
import com.anma.sb.dbdeneratorsb.repo.CatRepo;
import com.anma.sb.dbdeneratorsb.repo.CountryRepo;
import com.anma.sb.dbdeneratorsb.repo.PersonRepo;
import com.anma.sb.dbdeneratorsb.services.convert.CarConverter;
import com.anma.sb.dbdeneratorsb.services.web.CarService;
import com.anma.sb.dbdeneratorsb.services.web.CatService;
import com.anma.sb.dbdeneratorsb.services.web.CountryService;
import com.anma.sb.dbdeneratorsb.services.web.PersonWebService;
import com.anma.sb.dbdeneratorsb.services.convert.CatToWebCat;
import com.anma.sb.dbdeneratorsb.services.convert.CountryConverter;
import com.anma.sb.dbdeneratorsb.services.convert.PersonConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class Bootstrap implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(Bootstrap.class);
    private final CatService catService;
    private final CatRepo catRepo;
    private final PersonRepo personRepo;
    private final CatToWebCat catConverter;
    private final PersonWebService personWebService;
    private final PersonConverter personConverter;
    private final CountryRepo countryRepo;
    private final CountryConverter countryConverter;
    private final CountryService countryService;
    private final CarRepo carRepo;
    private final CarService carService;
    private final CarConverter carConverter;

    @Autowired
    public Bootstrap(CatService catService, CatRepo catRepo,
                     PersonRepo personRepo, CatToWebCat catCOnverter,
                     PersonWebService personWebService,
                     PersonConverter personConverter, CountryRepo countryRepo,
                     CountryConverter countryConverter, CountryService countryService,
                     CarRepo carRepo, CarService carService, CarConverter carConverter) {
        this.catService = catService;
        this.catRepo = catRepo;
        this.personRepo = personRepo;
        this.catConverter = catCOnverter;
        this.personWebService = personWebService;
        this.personConverter = personConverter;
        this.countryRepo = countryRepo;
        this.countryConverter = countryConverter;
        this.countryService = countryService;
        this.carRepo = carRepo;
        this.carService = carService;
        this.carConverter = carConverter;
    }

    @Override
    public void run(String... args) throws Exception {

        createCars();

    }

    private void createCars() {

        for (int i = 0; i < carService.alLCars().size(); i++) {
            Object[] array = carService.alLCars().toArray();
            Car car = carConverter.convert((CarWeb) array[i]);
            car.setCreatedAt(LocalDateTime.now());
            car.setCarId((long) i);
            car.setId(UUID.randomUUID().toString());
            carRepo.save(car);
        }

//        carService.alLCars().forEach(carW -> {
//
//        });

    }

    private void createCountries() {
//        if (countryService.allCountries().size() == 0) {
            logger.info("[ === ] creating countries ...");
        for (int i = 1; i < countryService.allCountries().size(); i++) {
            Object[] array = countryService.allCountries().toArray();
            Country country = countryConverter.convert((CountryWeb) array[i]);
            country.setId(i);
//            System.out.println((CountryWeb) array[i]);
            countryRepo.save(country);
        }
//            countryService.allCountries().forEach(countryWeb -> {
//                Country country = countryConverter.convert(countryWeb);
//                country.setId();
//                countryRepo.save(country);
//            });
//        }
    }

    private void createPersons() {
        logger.info("[ === ] creating Persons ...");
//        for (int i = 0; i < personWebService.allPersons().size(); i++) {
//            Object[] array = personWebService.allPersons().toArray();
//            Person person = personConverter.convert((PersonWeb) array[i]);
//            person.setCountryId();
//            person.setGender();
//            person.setId(i);
//            personRepo.save(person);
//        }
        personWebService.allPersons().forEach(personWeb -> {
            logger.info("[ ** ] " + personWeb.toString());
            Person person = personConverter.convert(personWeb);
            logger.info("[ --- ] person created: ");
            logger.info(person.toString());
            personRepo.save(person);

        });
    }

    private void createCats() {
        logger.info("[ === ] creating Cats ...");
        catService.allCats().forEach(catWeb -> {
            Cat cat = catConverter.convert(catWeb);
            logger.info("[***] cat" + cat.toString());
            logger.info(cat.toString());
            catRepo.save(cat);
        });
    }
}

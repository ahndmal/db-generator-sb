package com.anma.sb.dbdeneratorsb;

import com.anma.sb.dbdeneratorsb.models.Cat;
import com.anma.sb.dbdeneratorsb.models.Country;
import com.anma.sb.dbdeneratorsb.models.Person;
import com.anma.sb.dbdeneratorsb.models.web.CountryWeb;
import com.anma.sb.dbdeneratorsb.models.web.PersonWeb;
import com.anma.sb.dbdeneratorsb.repo.CatRepo;
import com.anma.sb.dbdeneratorsb.repo.CountryRepo;
import com.anma.sb.dbdeneratorsb.repo.PersonRepo;
import com.anma.sb.dbdeneratorsb.services.web.CatService;
import com.anma.sb.dbdeneratorsb.services.web.CountryService;
import com.anma.sb.dbdeneratorsb.services.web.PersonWebService;
import com.anma.sb.dbdeneratorsb.services.convert.CatToWebCat;
import com.anma.sb.dbdeneratorsb.services.convert.CountryConverter;
import com.anma.sb.dbdeneratorsb.services.convert.PersonConverter;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    @Autowired
    public Bootstrap(CatService catService, CatRepo catRepo,
                     PersonRepo personRepo, CatToWebCat catCOnverter,
                     PersonWebService personWebService,
                     PersonConverter personConverter, CountryRepo countryRepo,
                     CountryConverter countryConverter, CountryService countryService) {
        this.catService = catService;
        this.catRepo = catRepo;
        this.personRepo = personRepo;
        this.catConverter = catCOnverter;
        this.personWebService = personWebService;
        this.personConverter = personConverter;
        this.countryRepo = countryRepo;
        this.countryConverter = countryConverter;
        this.countryService = countryService;
    }

    @Override
    public void run(String... args) throws Exception {



//        personRepo.findAll().forEach(p -> {
//            p.setCatId(RandomUtils.nextLong(1, 66));
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

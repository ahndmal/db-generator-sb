package com.anma.sb.dbdeneratorsb;

import com.anma.sb.dbdeneratorsb.models.Cat;
import com.anma.sb.dbdeneratorsb.models.Person;
import com.anma.sb.dbdeneratorsb.repo.CatRepo;
import com.anma.sb.dbdeneratorsb.repo.PersonRepo;
import com.anma.sb.dbdeneratorsb.services.CatService;
import com.anma.sb.dbdeneratorsb.services.PersonWebService;
import com.anma.sb.dbdeneratorsb.services.convert.CatToWebCat;
import com.anma.sb.dbdeneratorsb.services.convert.PersonConverter;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CatService catService;
    private final CatRepo catRepo;
    private final PersonRepo personRepo;
    private final CatToWebCat catConverter;
    private final PersonWebService personWebService;
    private final PersonConverter personConverter;

    @Autowired
    public Bootstrap(CatService catService, CatRepo catRepo,
                     PersonRepo personRepo, CatToWebCat catCOnverter,
                     PersonWebService personWebService,
                     PersonConverter personConverter) {
        this.catService = catService;
        this.catRepo = catRepo;
        this.personRepo = personRepo;
        this.catConverter = catCOnverter;
        this.personWebService = personWebService;
        this.personConverter = personConverter;
    }

    @Override
    public void run(String... args) throws Exception {

        createPersons();

    }

    private void createPersons() {
        personWebService.allPersons().forEach(personWeb -> {
            Person person = personConverter.convert(personWeb);

            personRepo.save(person);
        });
    }

    private void createCats() {
        catService.allCats().forEach(catWeb -> {
            Cat cat = catConverter.convert(catWeb);
            cat.setName(Faker.instance().cat().name());
            cat.setBreed(Faker.instance().cat().breed());
            cat.setRegistry(Faker.instance().cat().registry());

            catRepo.save(cat);
        });
    }
}

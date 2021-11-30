package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Person;
import com.anma.sb.dbdeneratorsb.models.web.PersonWeb;
import com.anma.sb.dbdeneratorsb.repo.CountryRepo;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PersonConverterImpl implements PersonConverter {

    private final CountryRepo countryRepo;

    public PersonConverterImpl(CountryRepo countryRepo) {
        this.countryRepo = countryRepo;
    }

    @Override
    public Person convert(PersonWeb personWeb) {
        Random random = new Random();
//        List<Integer>countriesIds = new ArrayList<>(248);
//        random.ints(248,403, 651).reduce();
        return Person.builder()
                .id(personWeb.getId())
                .name(personWeb.getName())
                .fullName(personWeb.getName())
                .email(personWeb.getEmail())
                .gender(personWeb.getGender())
                .status(personWeb.getStatus())
                .age(random.nextInt(90))
                .hasChildren(random.nextBoolean())
                .countryCode(countryRepo.findById(RandomUtils.nextInt(403, 651)).get().getCode())
                .engaged(random.nextBoolean())
                .createdAt(LocalDateTime.now())
                .countryId(RandomUtils.nextInt(403, 651))
//                .cats()
                //.cars()
                .build();
    }

    @Override
    public PersonWeb convert(Person person) {
        return null;
    }
}

package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Cat;
import com.anma.sb.dbdeneratorsb.models.web.CatWeb;
import com.anma.sb.dbdeneratorsb.repo.PersonRepo;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CatToWebCatImpl implements CatToWebCat {

    private final PersonRepo personRepo;

    public CatToWebCatImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public Cat convert(CatWeb catWeb) {
        return Cat.builder()
                .id(catWeb.getId())
                .age(new Random().nextInt(17))
                .countryCodes(catWeb.getCountryCodes())
                .adaptability(catWeb.getAdaptability())
                .dogFriendly(catWeb.getDogFriendly())
                .hairless(catWeb.getHairless())
                .indoor(catWeb.getIndoor())
                .intelligence(catWeb.getIntelligence())
                .wikipediaUrl(catWeb.getWikipediaUrl())
                .origin(catWeb.getOrigin())
                .name(Faker.instance().cat().name())
                .breed(Faker.instance().cat().breed())
                .registry(Faker.instance().cat().registry())
                .personId(RandomUtils.nextLong(1, 1725))        // todo - change to get real ids
                .build();
    }

    @Override
    public CatWeb convert(Cat cat) {
        return null;
    }
}

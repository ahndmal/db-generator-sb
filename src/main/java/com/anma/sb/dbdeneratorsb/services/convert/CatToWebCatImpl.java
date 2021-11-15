package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Cat;
import com.anma.sb.dbdeneratorsb.models.web.CatWeb;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CatToWebCatImpl implements CatToWebCat {

    @Override
    public Cat convert(CatWeb catWeb) {
        return Cat.builder()
                .age(new Random().nextInt(13))
                .countryCodes(catWeb.getCountryCodes())
                .adaptability(catWeb.getAdaptability())
                .dogFriendly(catWeb.getDogFriendly())
                .id(catWeb.getId())
                .hairless(catWeb.getHairless())
                .indoor(catWeb.getIndoor())
                .intelligence(catWeb.getIntelligence())
                .wikipediaUrl(catWeb.getWikipediaUrl())
                .origin(catWeb.getOrigin())
                .name(Faker.instance().cat().name())
                .breed(Faker.instance().cat().breed())
                .registry(Faker.instance().cat().registry())
                .build();
    }

    @Override
    public CatWeb convert(Cat cat) {
        return null;
    }
}

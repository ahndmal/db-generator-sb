package com.anma.sb.dbdeneratorsb.services;

import com.anma.sb.dbdeneratorsb.models.web.CatWeb;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    private RestTemplate template = new RestTemplate();

    @Override
    public List<CatWeb> allCats() {

        CatWeb[] catsWeb = template.getForObject("https://api.thecatapi.com/v1/breeds", CatWeb[].class);

        return Arrays.asList(catsWeb);
    }

    @Override
    public CatWeb catByBreed(String breed) {
        return null;
    }
}

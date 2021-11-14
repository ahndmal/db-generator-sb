package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.web.CatWeb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Arrays;
import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    private final RestTemplate template = new RestTemplate();
    private WebClient webClient = WebClient.create();
    private final String CATS_URL = "https://api.thecatapi.com/v1/breeds";

    private final Environment environment;

    @Autowired
    public CatServiceImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public List<CatWeb> allCats() {

        CatWeb[] catsWeb = template.getForObject(CATS_URL, CatWeb[].class);
        return Arrays.asList(catsWeb);
//        Mono<CatWeb[]> cats = webClient.get()
//                .uri(URI.create(CATS_URL))
//                .retrieve()
//                .bodyToMono(CatWeb[].class);
    }

    @Override
    public CatWeb catByBreed(String breed) {
        return template.getForObject(CATS_URL + "/" + breed, CatWeb.class);
    }
}

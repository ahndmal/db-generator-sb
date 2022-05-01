package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.web.CarWeb;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final RestTemplate template = new RestTemplate();
    private WebClient webClient = WebClient.create();
    private final String URL = "https://the-vehicles-api.herokuapp.com/brands/";

    @Override
    public List<CarWeb> alLCars() {
//         webClient.get().uri(URL).retrieve().bodyToMono(List.class).subscribe();
        return Arrays.stream(template.getForObject(URL, CarWeb[].class))
                .collect(Collectors.toList());
    }

    @Override
    public CarWeb carById(long id) {
        return null;
    }
}

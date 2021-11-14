package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.web.PersonWeb;
import com.anma.sb.dbdeneratorsb.models.web.PersonWebArray;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonWebServiceImpl implements PersonWebService {

    private final RestTemplate template = new RestTemplate();
    private WebClient webClient = WebClient.create();


    private final Environment environment;

    public PersonWebServiceImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public PersonWeb getPersonById(long id) {
        final String URL = environment.getProperty("links.persons");
        return template.getForObject(URI.create(URL), PersonWeb.class);
    }

    @Override
    public List<PersonWeb> allPersons() {
        String next = "";
        final String URL = environment.getProperty("links.persons");
        PersonWebArray personsWeb = template.getForObject(URI.create(URL), PersonWebArray.class);
        List<PersonWeb> allPersons = new ArrayList<>(Arrays.asList(personsWeb.getData()));
        next = personsWeb.getMeta().getPagination().getLinks().getNext();
        if (next != null) {
            while (next != null) {
                PersonWebArray temp = template.getForObject(URI.create(next), PersonWebArray.class);
                allPersons.addAll(Arrays.asList(temp.getData()));
                next = personsWeb.getMeta().getPagination().getLinks().getNext();
            }
        }
        return allPersons;
    }
}

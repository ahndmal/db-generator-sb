package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.Person;
import com.anma.sb.dbdeneratorsb.models.web.PersonWeb;
import com.anma.sb.dbdeneratorsb.models.web.PersonWebArray;
import com.anma.sb.dbdeneratorsb.repo.PersonRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonWebServiceImpl implements PersonWebService {

    private final RestTemplate template = new RestTemplate();
    private final PersonRepo personRepo;
    private WebClient webClient = WebClient.create();

    private final Environment environment;

    public PersonWebServiceImpl(PersonRepo personRepo, Environment environment) {
        this.personRepo = personRepo;
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
        int length = personsWeb.getData().length;
        if (next != null) {
            while (next != null && length > 0) {
                PersonWebArray temp = template.getForObject(URI.create(next), PersonWebArray.class);
                length = temp.getData().length;
                if (length < 1) {
                    return allPersons;
                } else {
                    allPersons.addAll(Arrays.asList(temp.getData()));
                    next = temp.getMeta().getPagination().getLinks().getNext();
                    log.info("[ *** ]  next URL " + next);
                    log.info("[ === ] Next iteration " + allPersons.size());
                }
            }
        }
        log.info("[ *** allPersons size] " + allPersons.size());
        return allPersons;
    }

    @Override
    public List<Long> personIds() {
        return personRepo.findAll()
                .stream()
                .map(Person::getId)
                .collect(Collectors.toList());
    }

    @Override
    public Long getPersRandomId() {
        return personIds().get(
                new Random().nextInt(personRepo.findAll().size()));
    }

    @Override
    public List<PersonWeb> allPersonsClient() {
        return null;
    }
}

package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Person;
import com.anma.sb.dbdeneratorsb.models.web.PersonWeb;
import org.springframework.stereotype.Service;

@Service
public class PersonConverterImpl implements PersonConverter {

    @Override
    public Person convert(PersonWeb personWeb) {
        return Person.builder()
                .email(personWeb.getEmail())
                .gender(personWeb.getGender())
                .id(personWeb.getId())
                .status(personWeb.getStatus())
                .name(personWeb.getName())
                .build();
    }

    @Override
    public PersonWeb convert(Person person) {
        return null;
    }
}

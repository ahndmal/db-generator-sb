package com.anma.sb.dbdeneratorsb.services.web;

import com.anma.sb.dbdeneratorsb.models.web.PersonWeb;

import java.util.List;

public interface PersonWebService {
    PersonWeb getPersonById(long id);
    List<PersonWeb> allPersons();
}

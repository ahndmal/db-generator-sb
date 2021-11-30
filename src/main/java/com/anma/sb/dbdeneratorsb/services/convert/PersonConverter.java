package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Cat;
import com.anma.sb.dbdeneratorsb.models.Person;
import com.anma.sb.dbdeneratorsb.models.web.CatWeb;
import com.anma.sb.dbdeneratorsb.models.web.PersonWeb;

public interface PersonConverter {
    Person convert(PersonWeb personWeb);
    PersonWeb convert(Person person);
}

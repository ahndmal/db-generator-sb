package com.anma.sb.dbdeneratorsb.repo;

import com.anma.sb.dbdeneratorsb.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}

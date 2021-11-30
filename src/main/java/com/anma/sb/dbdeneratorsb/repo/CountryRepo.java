package com.anma.sb.dbdeneratorsb.repo;

import com.anma.sb.dbdeneratorsb.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Integer> {
}

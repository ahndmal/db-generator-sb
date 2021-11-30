package com.anma.sb.dbdeneratorsb.repo;

import com.anma.sb.dbdeneratorsb.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car, Long> {
}

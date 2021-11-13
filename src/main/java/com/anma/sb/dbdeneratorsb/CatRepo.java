package com.anma.sb.dbdeneratorsb;

import com.anma.sb.dbdeneratorsb.models.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepo extends JpaRepository<Cat, Long> {
}

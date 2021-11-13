package com.anma.sb.dbdeneratorsb;

import com.anma.sb.dbdeneratorsb.services.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CatService catService;

    @Autowired
    public Bootstrap(CatService catService) {
        this.catService = catService;
    }

    @Override
    public void run(String... args) throws Exception {

        catService.allCats().forEach(System.out::println);

    }
}

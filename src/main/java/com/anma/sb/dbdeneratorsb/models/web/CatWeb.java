package com.anma.sb.dbdeneratorsb.models.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatWeb {

    private String id;
    private String name;
    private String color;
    private String breed;
    private String registry;
    private int age;

}
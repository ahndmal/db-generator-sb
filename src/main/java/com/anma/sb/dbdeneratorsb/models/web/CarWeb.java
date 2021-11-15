package com.anma.sb.dbdeneratorsb.models.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;

@Data
public class CarWeb {

    private long catId;
    private String id;
    private String model;
    private String color;
    private String registry;
    private String origin;
    @JsonProperty(value = "country_codes") private String countryCodes;
    @JsonProperty(value = "wikipedia_url") private String wikipediaUrl;
    private int age;
    @JsonProperty(value = "person_id") private long personId;
}

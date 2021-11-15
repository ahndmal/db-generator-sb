package com.anma.sb.dbdeneratorsb.models.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatWeb {

    private long catId;
    private String id;
    private String name;
    private String color;
    private String breed;
    private String registry;
    private String origin;
    @JsonProperty(value = "country_codes")
    private String countryCodes;
    @JsonProperty(value = "wikipedia_url") private String wikipediaUrl;
    private int age;
    private int indoor;
    private int adaptability;
    @JsonProperty(value = "dog_friendly") private int dogFriendly;
    private int intelligence;
    private int hairless;

}

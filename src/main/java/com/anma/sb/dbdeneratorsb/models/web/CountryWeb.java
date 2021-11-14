package com.anma.sb.dbdeneratorsb.models.web;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true, value = {"nativeName"})
//@JsonTypeInfo(
//        use = JsonTypeInfo.Id.NAME,
//        include = JsonTypeInfo.As.PROPERTY,
//        property = "name")
//@JsonSubTypes(
//        @JsonSubTypes.Type(value = CountryWeb.Name.class, name = "name")
//        @JsonSubTypes(
//                @JsonSubTypes.Type(value = CountryWeb.Name.NativeName.class, name = "name"),
//        })
//)
public class CountryWeb {

    private int id;
    private long area;
    private long population;
    private String status;
    private String unMember;
    private String cca2;
    private String region;
    private boolean independent;
    private String[] tld;
    private String[] continents;
    private String[] borders;
    private Map<String, String> languages;
    private String[] capital;
    private Name name;
//    private Map<String, String> name;


//    @JsonIgnoreProperties(ignoreUnknown = true, value = "nativeName")
//    static class Name {
//        private String common;
//        private String official;
//        static class NativeName {
//            Map<String, String> prs;
//        }
//    }
}

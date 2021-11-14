package com.anma.sb.dbdeneratorsb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
@Data
public class Country {

    @Id
    @Column(name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long area;
    private long population;
    private String status;
    @Column(name = "un_member") private String unMember;
    private String cca2;
    private String code;
//    private Tld tld;
    private String name;
    @Column(name = "continent_name") private String continentName;
    private String region;
    private String capital;
    private String languages;
    private String borders;
    private String continents;
    private boolean independent;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "country_person", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "country_id"))
//    @OneToMany
//    private List<Person> persons;
//    private List<String> tld;


//    static class CountryName {
//        private String common;
//        private String official;
//    }
//
//    static class Languages {
//
//    }


}

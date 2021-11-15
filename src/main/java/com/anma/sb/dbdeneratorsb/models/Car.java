package com.anma.sb.dbdeneratorsb.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private long catId;
    private String id;
    private String model;
    private String color;
    private String registry;
    private String origin;
    @Column(name = "country_codes") private String countryCodes;
    @Column(name = "wikipedia_url") private String wikipediaUrl;
    private int age;
    @Column(name = "person_id") private long personId;


}
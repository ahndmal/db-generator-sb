package com.anma.sb.dbdeneratorsb.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private long carId;
    private String id;
    private String model;
    private String color;
    private String registry;
    private String origin;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @Column(name = "country_codes") private String countryCodes;
    @Column(name = "max_speed") private int maxSpeed;
    private int age;
    @Column(name = "person_id") private long personId;


}
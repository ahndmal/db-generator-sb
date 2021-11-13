package com.anma.sb.dbdeneratorsb.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cat {

    @Id
    private String id;
    private String name;
    private String color;
    private String breed;
    private String registry;
    private int age;

}
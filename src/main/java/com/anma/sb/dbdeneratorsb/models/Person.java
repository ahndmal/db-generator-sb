package com.anma.sb.dbdeneratorsb.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    private long id;
    private String name;
    private String email;
    private String gender;
    private String status;
    private boolean hasChildren;
}

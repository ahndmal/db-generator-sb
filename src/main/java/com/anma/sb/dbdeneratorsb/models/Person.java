package com.anma.sb.dbdeneratorsb.models;

import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "persons")
@Builder
public class Person {

    @Id
    @Column(name = "person_id")
    private long id;
    private String name;
    private String email;
    private String gender;
    private String status;
    private boolean hasChildren;
    private LocalDateTime createdAt = LocalDateTime.now();
    @OneToMany
    private List<Cat> cats;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;

    public Person() {}

    public Person(long id, String name, String email, String gender, String status, boolean hasChildren, LocalDateTime createdAt, List<Cat> cats, Country country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
        this.hasChildren = hasChildren;
        this.createdAt = createdAt;
        this.cats = cats;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Cat> getCats() {
        return cats;
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

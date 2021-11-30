package com.anma.sb.dbdeneratorsb.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "city_id")
    private long id;
    private String name;
    @Column(name = "country_code")
    private String code;
    private String continent;
    @Column(name = "created_at") private LocalDateTime createdAt;
    @Column(name = "country_id") private long countryId;
    private long population;

    public City() {
    }

    public City(long id, String name, String code, String continent, LocalDateTime createdAt, long countryId, long population) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.continent = continent;
        this.createdAt = createdAt;
        this.countryId = countryId;
        this.population = population;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}

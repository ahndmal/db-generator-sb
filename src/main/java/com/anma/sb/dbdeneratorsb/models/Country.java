package com.anma.sb.dbdeneratorsb.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id")
    private int id;
    private long area;
    private String status;
    private String unMember;
    private String cca2;
    private String region;
    private boolean independent;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "country_person", joinColumns = @JoinColumn(name = "person_id"), inverseJoinColumns = @JoinColumn(name = "country_id"))
    @OneToMany
    private List<Person> persons;
//    private List<String> tld;

//    static class CountryName {
//        private String common;
//        private String official;
//    }
//
//    static class Languages {
//
//    }

    public Country() {}

    public Country(int id, long area, String status, String unMember, String cca2, String region, boolean independent, List<Person> persons) {
        this.id = id;
        this.area = area;
        this.status = status;
        this.unMember = unMember;
        this.cca2 = cca2;
        this.region = region;
        this.independent = independent;
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUnMember() {
        return unMember;
    }

    public void setUnMember(String unMember) {
        this.unMember = unMember;
    }

    public String getCca2() {
        return cca2;
    }

    public void setCca2(String cca2) {
        this.cca2 = cca2;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
    }
}

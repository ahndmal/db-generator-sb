package com.anma.sb.dbdeneratorsb.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "persons")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private long id;
    private String name;
    @Column(name = "full_name") private String fullName;
    private String email;
    private String gender;
    private String status;
    private int age;
    private int cars;
    @Column(name="country_code") private String countryCode;
    @Column(name = "has_children") private boolean hasChildren;
    private boolean engaged;
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name="cat_id") private long catId;
//    @OneToMany
//    private List<Cat> cats;
    @Column(name = "country_id") private long countryId;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
//    private Country country;


}

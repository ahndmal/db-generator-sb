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
    @Column(name = "person_id")
    private long id;
    private String name;
    private String email;
    private String gender;
    private String status;
    @Column(name = "has_children") private boolean hasChildren;
    private LocalDateTime createdAt = LocalDateTime.now();
    @OneToMany
    private List<Cat> cats;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    private Country country;


}

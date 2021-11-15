package com.anma.sb.dbdeneratorsb.models.web;

import com.anma.sb.dbdeneratorsb.models.Cat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonWeb {

    private long id;
    private String name;
    private String fullName;
    private String email;
    private int age;
    private String gender;
    private String status;
    private LocalDateTime createdAt;
    private String countryCode;
    private boolean hasChildren;
    private boolean engaged;
    private int cars;
    @JsonIgnore private List<Cat> cats;
}

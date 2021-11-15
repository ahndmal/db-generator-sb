package com.anma.sb.dbdeneratorsb.models.web;

import com.anma.sb.dbdeneratorsb.models.Cat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;
    @JsonProperty(value = "country_code")
    private String countryCode;
    @JsonProperty(value = "has_children")
    private boolean hasChildren;
    private boolean engaged;
    private int cars;
    @JsonIgnore private List<Cat> cats;
}

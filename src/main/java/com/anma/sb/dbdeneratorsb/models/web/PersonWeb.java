package com.anma.sb.dbdeneratorsb.models.web;

import com.anma.sb.dbdeneratorsb.models.Cat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonWeb {

    private long id;
    private String name;
    private String email;
    private String gender;
    private String status;
    private boolean hasChildren;
    @JsonIgnore
    private List<Cat> cats;
}

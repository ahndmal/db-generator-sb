package com.anma.sb.dbdeneratorsb.models.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityWeb {

    private long id;
    private String name;
    private String code;
    private String continent;
    private long population;

}

package com.anma.sb.dbdeneratorsb.models.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryWeb {

    private int id;
    private long area;
    private String status;
    private String unMember;
    private String cca2;
    private String region;
    private boolean independent;
}

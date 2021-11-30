package com.anma.sb.dbdeneratorsb.models.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Links {

    private String previous;
    private String current;
    private String next;
}

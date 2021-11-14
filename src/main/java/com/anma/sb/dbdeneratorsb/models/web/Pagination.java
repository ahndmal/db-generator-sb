package com.anma.sb.dbdeneratorsb.models.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagination {
    private int total;
    private int pages;
    private int page;
    private int limit;
    private Links links;
}

package com.anma.sb.dbdeneratorsb.models.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CommentWeb {

    public long id;
    public String body;
    public String category;
    public LocalDateTime createdAt;
    @JsonProperty(value = "author_id") public long authorId;
}

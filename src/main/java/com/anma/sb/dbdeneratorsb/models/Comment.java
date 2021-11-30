package com.anma.sb.dbdeneratorsb.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String body;
    public String category;
    @Column(name = "created_at")
    public LocalDateTime createdAt;
    @Column(name = "author_id")
    public long authorId;
}

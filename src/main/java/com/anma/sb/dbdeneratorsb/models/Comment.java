package com.anma.sb.dbdeneratorsb.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long id;
    public String body;
    public String category;
    public LocalDateTime createdAt;
    @Column(name = "author_id") public long authorId;
}

package com.anma.sb.dbdeneratorsb.repo;

import com.anma.sb.dbdeneratorsb.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long> {
}

package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Comment;
import com.anma.sb.dbdeneratorsb.models.web.CommentWeb;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentConverterImpl implements CommentConverter {

    @Override
    public Comment convert(CommentWeb commentWeb) {
        Comment comment = new Comment();
        comment.setId(commentWeb.getId());
        comment.setBody(commentWeb.getBody());
        comment.setAuthorId(commentWeb.getAuthorId());
        comment.setCategory(commentWeb.getCategory());
        comment.setCreatedAt(LocalDateTime.now());
        return comment;
    }

    @Override
    public CommentWeb convert(Comment comment) {
        return null;
    }
}

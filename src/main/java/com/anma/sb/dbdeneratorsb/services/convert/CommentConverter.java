package com.anma.sb.dbdeneratorsb.services.convert;

import com.anma.sb.dbdeneratorsb.models.Comment;
import com.anma.sb.dbdeneratorsb.models.web.CommentWeb;

public interface CommentConverter {

    public Comment convert(CommentWeb commentWeb);
    public CommentWeb convert(Comment comment);
}

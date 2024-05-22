package edu.itstep.example.repository;

import edu.itstep.example.model.Comment;
import org.springframework.stereotype.Component;


public interface CommentRepository {

    void storeComment(Comment comment);
}

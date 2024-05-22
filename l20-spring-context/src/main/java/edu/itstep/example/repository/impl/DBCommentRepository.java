package edu.itstep.example.repository.impl;

import edu.itstep.example.model.Comment;
import edu.itstep.example.repository.CommentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DBCommentRepository implements CommentRepository {

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Store comment: " + comment.getText());
    }
}

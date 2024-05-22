package edu.itstep.example;

import edu.itstep.example.config.AppConfig;
import edu.itstep.example.model.Comment;
import edu.itstep.example.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Comment comment = new Comment();

        comment.setAuthor("Joe");
        comment.setText("Hello world!");

        CommentService commentService = context.getBean(CommentService.class);

        commentService.publishComment(comment);
    }
}

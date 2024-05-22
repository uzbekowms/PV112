package edu.itstep.example.proxy.impl;

import edu.itstep.example.model.Comment;
import edu.itstep.example.proxy.CommentNotificationProxy;
import org.springframework.stereotype.Component;

@Component("emailProxy")
public class EmailCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification: " + comment.getText());
    }


    // CommentService(interface) -> CommentServiceImpl -> DefaultCommentService
}

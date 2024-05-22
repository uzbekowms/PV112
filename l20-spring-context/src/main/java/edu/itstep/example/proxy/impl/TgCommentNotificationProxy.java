package edu.itstep.example.proxy.impl;

import edu.itstep.example.model.Comment;
import edu.itstep.example.proxy.CommentNotificationProxy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tgProxy")
public class TgCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending in tg: " + comment.getText());
    }
}

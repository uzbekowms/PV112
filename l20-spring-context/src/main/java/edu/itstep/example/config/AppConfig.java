package edu.itstep.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.itstep.example")
public class AppConfig {

//
//    @Bean
//    public CommentRepository commentRepository() {
//        return new DBCommentRepository();
//    }
//
//    @Bean
//    public CommentNotificationProxy commentNotificationProxy() {
//        return new EmailCommentNotificationProxy();
//    }
//
//    @Bean
//    public CommentService commentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {
//        return new CommentService(commentRepository, commentNotificationProxy);
//    }

}

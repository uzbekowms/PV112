package org.example.bean;

import org.example.bean.config.AppConfig;
import org.example.bean.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // XML-Config
        // Java Based Config + Program
        // Annotation Based Config @Bean @Component @Service @Repository
//        var context = new ClassPathXmlApplicationContext();
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
//
//        Parrot p2 = context.getBean(Parrot.class);
//        System.out.println(p2.getName());
//        System.out.println(p == p2);

        String greetings = context.getBean(String.class);
        System.out.println(greetings);

        Integer ten = context.getBean(Integer.class);
        System.out.println(ten);
    }
}
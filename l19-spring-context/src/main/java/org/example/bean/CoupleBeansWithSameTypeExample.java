package org.example.bean;

import org.example.bean.config.AppConfig;
import org.example.bean.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoupleBeansWithSameTypeExample {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());
    }
}

package org.example.component;

import org.example.component.config.AppConfig;
import org.example.component.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());


    }
}

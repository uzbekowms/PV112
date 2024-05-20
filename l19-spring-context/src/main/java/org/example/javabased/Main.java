package org.example.javabased;

import org.example.javabased.config.AppConfig;
import org.example.javabased.model.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        Parrot parrot = new Parrot();
        parrot.setName("X");

        Supplier<Parrot> parrotSupplier = () -> parrot;

        context.registerBean("parrot1", Parrot.class, parrotSupplier);

        Parrot parrotFromContext = context.getBean(Parrot.class);

        System.out.println(parrotFromContext.getName());
        System.out.println(parrotFromContext == parrot);
    }
}

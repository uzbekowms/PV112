package edu.itstep.loop;

import edu.itstep.loop.config.AppConfig;
import edu.itstep.loop.model.Parrot;
import edu.itstep.loop.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(person);
        System.out.println(parrot);
    }
}

package edu.itstep.wiring;

import edu.itstep.wiring.model.Parrot;
import edu.itstep.wiring.model.Person;
import edu.itstep.wiring.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = context.getBean(Person.class);
        Parrot parrot = context.getBean(Parrot.class);

        System.out.println(person.getName());
        System.out.println(parrot.getName());

        System.out.println(person.getParrot());

        System.out.println(person.getParrot() == parrot);
    }
}
package edu.itstep.autowiring;

import edu.itstep.autowiring.config.AppConfig;
import edu.itstep.autowiring.model.Parrot;
import edu.itstep.autowiring.model.Person;
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

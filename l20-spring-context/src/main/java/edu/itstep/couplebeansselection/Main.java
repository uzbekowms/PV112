package edu.itstep.couplebeansselection;

import edu.itstep.couplebeansselection.config.AppConfig;
import edu.itstep.couplebeansselection.model.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = context.getBean(Person.class);

        System.out.println(person.getName());

        System.out.println(person.getParrot());

    }
}

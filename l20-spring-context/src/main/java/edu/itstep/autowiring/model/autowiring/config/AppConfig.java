package edu.itstep.autowiring.model.autowiring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example.autowiring")
public class AppConfig {
//
//    @Bean
//    public Parrot parrot() {
//        System.out.println("Parrot created");
//        Parrot parrot = new Parrot();
//        parrot.setName("Igor");
//        return parrot;
//    }
//
//    @Bean
//    public Parrot parrot2() {
//        System.out.println("Parrot created");
//        Parrot parrot = new Parrot();
//        parrot.setName("Petro");
//        return parrot;
//    }
//
//    @Bean
//    public Parrot parrot3() {
//        System.out.println("Parrot created");
//        Parrot parrot = new Parrot();
//        parrot.setName("Joe");
//        return parrot;
//    }

//    @Bean
//    public Person person() {
//        Person person = new Person();
//        person.setName("Joe");
//        return person;
//    }

//    // First method
//    @Bean
//    public Person person() {
//        Person person = new Person();
//        person.setName("Joe");
//        person.setParrot(parrot());
//        return person;
//    }

    // Second method
//    @Bean
//    public Person person(Parrot parrot) {
//        Person person = new Person();
//        person.setName("Joe");
//        person.setParrot(parrot);
//        return person;
//    }
}

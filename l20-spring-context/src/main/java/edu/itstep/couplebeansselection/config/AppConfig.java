package edu.itstep.couplebeansselection.config;

import edu.itstep.couplebeansselection.model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.itstep.couplebeansselection")
public class AppConfig {

    @Bean
    public Parrot firstParrot() {
        System.out.println("Parrot firstParrot created");
        Parrot parrot = new Parrot();
        parrot.setName("Igor");
        return parrot;
    }

    @Bean
    public Parrot secondParrot() {
        System.out.println("Parrot secondParrot created");
        Parrot parrot = new Parrot();
        parrot.setName("Petro");
        return parrot;
    }

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

//    @Bean
//    public Person person(@Qualifier("parrot2") Parrot parrot2) {
//        Person person = new Person();
//        person.setName("Joe");
//        person.setParrot(parrot2);
//        return person;
//    }
}

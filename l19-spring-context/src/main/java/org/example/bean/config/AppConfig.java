package org.example.bean.config;

import org.example.bean.model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean
    public Parrot parrot() {
        System.out.println("Parrot created!");
        Parrot parrot = new Parrot();
        parrot.setName("Igor");
        return parrot;
    }

    @Bean
    @Primary
    public Parrot parrot2() {
        System.out.println("Parrot created 2!");
        Parrot parrot = new Parrot();
        parrot.setName("Petro");
        return parrot;
    }

    @Bean
    public Parrot parrot3() {
        System.out.println("Parrot created 3!");
        Parrot parrot = new Parrot();
        parrot.setName("John");
        return parrot;
    }

    @Bean
    public String greetings() {
        return "Hello";
    }

    @Bean
    public Integer ten() {
        return 10;
    }
}

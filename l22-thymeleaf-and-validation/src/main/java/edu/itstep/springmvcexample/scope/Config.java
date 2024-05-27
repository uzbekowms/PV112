package edu.itstep.springmvcexample.scope;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Random;

@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public String hello() {
        System.out.println("Created hello");
        return "hello";
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public RandomUser randomUser() {
        return new RandomUser(new Random().nextInt(10, 100), "hello");
    }

    @Bean
    @RequestScope
    public RandomUser randomUser2() {
        return new RandomUser(new Random().nextInt(10, 100), "hello");
    }

    @Bean
    @SessionScope
    public RandomUser randomUser3() {
        return new RandomUser(5, "Session");
    }

    @Bean
    @ApplicationScope
    public RandomUser randomUser4() {
        return new RandomUser(6, "Application");
    }
}


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class RandomUser {
    private int id;
    private String name;
}
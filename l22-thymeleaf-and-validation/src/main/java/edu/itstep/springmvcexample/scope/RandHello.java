package edu.itstep.springmvcexample.scope;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@ToString
@Getter
@Setter
public class RandHello {

    private int id;
    private String message;

    @PostConstruct
    public void init() {
        this.id = new Random().nextInt(10, 100);
        this.message = "Hello " + id + "!";
    }
}

package edu.itstep.couplebeansselection.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Person {

    private String name;

    private final Parrot parrot;

    public Person(Parrot firstParrot) {
        this.parrot = firstParrot;
    }
}

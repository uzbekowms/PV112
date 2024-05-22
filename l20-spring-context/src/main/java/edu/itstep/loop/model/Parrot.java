package edu.itstep.loop.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Parrot {
    @Autowired
    private Person person;
}

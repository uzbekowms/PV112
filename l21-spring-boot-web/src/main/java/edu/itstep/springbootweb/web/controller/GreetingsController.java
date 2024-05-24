package edu.itstep.springbootweb.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GreetingsController {


    @GetMapping("/greetings")
    public String greetings() {
        return "Hello world!";
    }

    @PostMapping("/greetings")
    public String anotherGreetings() {
        return "Another Hello world!";
    }
}

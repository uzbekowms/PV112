package org.example.aop.web.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.aop.domain.aspect.Loggable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    @Loggable
    public String test() {
        System.out.println("In test()");
        return "Test";
    }


    @GetMapping("/test2")
    @JsonIgnoreProperties
    public String test2(@RequestParam String text) {
        System.out.println("In test2()");
        System.out.println(5 / 0);
        return "Test2: " + text;
    }


    @GetMapping("/test3")
    @JsonIgnore
    @Loggable
    public String test3() {
        System.out.println("In test3()");
        throw new RuntimeException("Hello");
    }
}

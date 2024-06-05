package edu.itstep.aop.domain.controller;

import edu.itstep.aop.domain.annotation.Loggable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Loggable
    @GetMapping("/test")
    public String test(){
        return "Test";
    }
}

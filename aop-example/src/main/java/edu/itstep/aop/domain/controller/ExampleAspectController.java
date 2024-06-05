package edu.itstep.aop.domain.controller;

import edu.itstep.aop.domain.annotation.Loggable;
import edu.itstep.aop.domain.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aspect")
@RequiredArgsConstructor
public class ExampleAspectController {

    private final ExampleService exampleService;


    @Loggable
    @GetMapping("/1")
    public void doSomething() {
        exampleService.doSomething();
    }

    @Loggable
    @GetMapping("/2")
    public void doSomethingElseWithAnnotation() {
        exampleService.doSomethingElseWithAnnotation();
    }

    @Loggable
    @GetMapping("/3")
    public boolean check() {
        return exampleService.check();
    }
}

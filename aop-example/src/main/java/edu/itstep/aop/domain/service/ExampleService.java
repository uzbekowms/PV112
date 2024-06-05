package edu.itstep.aop.domain.service;

import edu.itstep.aop.domain.annotation.Loggable;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    @Loggable

    public void doSomething() {
        System.out.println("doSomething");
    }
    @Loggable

    public void doSomethingElseWithAnnotation() {
        System.out.println("doSomethingElseWithAnnotation");
    }

    @Loggable
    public boolean check() {
        System.out.println("check");
        return true;
    }
}

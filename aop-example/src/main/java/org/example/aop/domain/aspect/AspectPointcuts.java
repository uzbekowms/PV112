package org.example.aop.domain.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class AspectPointcuts {
    @Pointcut("execution(* org.example.aop.web.controller..*(..))")
    public void anyPublicControllerMethods() {
    }
}

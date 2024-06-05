package org.example.aop.domain.aspect;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggerAspect {


    @Pointcut("within(org.example.aop.domain.repository..*)")
    public void inRepository() {
    }

    @Pointcut("org.example.aop.domain.aspect.LoggerAspect.anyPublicControllerWithStringArgument() && inRepository()")
    public void tradingOperation() {
    }


    @Pointcut("execution(public * org.example.aop.web.controller..*(String))")
    public void anyPublicControllerWithStringArgument() {
    }

    @Pointcut("execution(* org.example.aop.web.controller..*(..))")
    public void anyPublicControllerMethods() {
    }

    @Pointcut("@annotation(Loggable)")
    public void loggableMethods() {
    }


    @Before("anyPublicControllerMethods()")
    public void logInfoBeforeLoggable(JoinPoint joinPoint) {
        log.info("BEFORE loggableMethods() \n{}\n{}", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature());
    }

    @After("loggableMethods()")
    public void logInfoAfterLoggable(JoinPoint joinPoint) {
        log.info("AFTER loggableMethods() \n{}\n{}", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature());
    }

    @AfterThrowing(value = "loggableMethods()", throwing = "ex")
    public void doRecoveryActionsLoggable(RuntimeException ex) {
        log.warn("After throwing - {}", ex.getMessage());
    }

    @Before(value = "org.example.aop.domain.aspect.AspectPointcuts.anyPublicControllerMethods() && args(test)")
    public void logInfoBefore(JoinPoint joinPoint, String test) {
        log.info("Argument - {}", test);
        log.info("BEFORE anyPublicControllerMethods() \n{}\n{}", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature());
    }

    @AfterReturning(value = "org.example.aop.domain.aspect.AspectPointcuts.anyPublicControllerMethods()", returning = "retValue")
    public void afterReturningCallAt(String retValue) {
        log.info("return value - {}", retValue);
    }

    @After("org.example.aop.domain.aspect.AspectPointcuts.anyPublicControllerMethods() && @annotation(jsonIgnore) ")
    public void logInfoAfter(JoinPoint joinPoint, JsonIgnore jsonIgnore) {
        log.info("AFTER anyPublicControllerMethods() \n{}\n{}", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature());
    }

    @Around("org.example.aop.domain.aspect.AspectPointcuts.anyPublicControllerMethods()")
    public Object aroundCallAt(ProceedingJoinPoint joinPoint) {
        log.info("AROUND BEFORE - {}", joinPoint.getSignature());

        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            log.info("AROUND AFTER - {}", joinPoint.getSignature());

        }
    }

    @AfterThrowing(value = "org.example.aop.domain.aspect.AspectPointcuts.anyPublicControllerMethods()", throwing = "ex")
    public void doRecoveryActions(RuntimeException ex) {
        log.warn("After throwing - {}", ex.getMessage());
    }

    /*
     * LOGGING LEVEL 1   2   3   4   5
     * TRACE         +   -   -   -   -
     * DEBUG         +   +   -   -   -
     * INFO          +   +   +   -   -
     * WARN          +   +   +   +   -
     * ERROR         +   +   +   +   +
     * java -jar app.jar --debug
     * */
}

package edu.itstep.aop.domain.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class LoggerAspect {


    private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);

    @Pointcut("@annotation(edu.itstep.aop.domain.annotation.Loggable)")
    public void loggerPointcut() {
    }

    @Pointcut("execution(public * edu.itstep.aop..*(..))")
    public void callPublicMethod() {}

    @Around("loggerPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() +
                " with args: " + Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(", ")));

        Object result = joinPoint.proceed();

        log.info("Method " + joinPoint.getSignature().getDeclaringTypeName() + " ended with result: " + (result == null ? "" : result.toString()));
        return result;
    }
}

package edu.itstep.aop.domain.aspect;

import edu.itstep.aop.domain.config.AOPConfig;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class ExampleAspect {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AOPConfig.class);

    @Pointcut("execution(public * edu.itstep.aop.domain.service..*(..))")
    public void callPublicMethod() {
    }

    @Pointcut("execution(* edu.itstep.aop.domain.service..*(..)) && args(list, ..)")
    public void callAtService(List<Object> list) {
    }

    @Before("callPublicMethod()")
    public void beforeCallPublicMethod(JoinPoint jp) {
        log.info(Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
        System.out.println(jp.getSignature());
        System.out.println(jp.getKind());
        System.out.println(jp.getTarget());
        System.out.println(jp.getThis());
        System.out.println(jp.getStaticPart());
        System.out.println(jp.getSourceLocation());
    }

    @Before(value = "callAtService(list)", argNames = "list")
    public void beforeCallArService(List<Object> list) {

    }
}

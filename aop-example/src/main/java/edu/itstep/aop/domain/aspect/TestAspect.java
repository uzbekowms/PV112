//package edu.itstep.aop.domain.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Aspect
//@Order(1)
//@Component
//public class TestAspect implements Ordered {
//    @Pointcut("execution(public String edu.itstep.aop..*(java.util.Date))")
//    public void beforeAll() {
//    }
//
//    @Before(value = "beforeAll() && args(arg)")
//    public void logger(JoinPoint joinPoint, String arg) {
//        System.out.println(joinPoint.getKind());
//        System.out.println(Arrays.toString(joinPoint.getArgs()));
//        System.out.println(joinPoint.getSignature());
//        System.out.println(joinPoint.getTarget());
//        System.out.println(joinPoint.getThis());
//        System.out.println(joinPoint.getSourceLocation());
//        System.out.println(joinPoint.getStaticPart());
//    }
//
//    @Around("beforeAll()")
//    public Object anotherLogger(ProceedingJoinPoint proceedingJoinPoint) {
//        try {
//            System.out.println("AROUND");
//            return proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}

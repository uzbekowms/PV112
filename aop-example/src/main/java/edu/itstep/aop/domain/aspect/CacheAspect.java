//package edu.itstep.aop.domain.aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Aspect
//@Component
//public class CacheAspect {
//
//    private final Map<Object[], Object> cache = new HashMap<>();
//
//    @Pointcut("@annotation(edu.itstep.aop.domain.annotation.Cache)")
//    public void cachePointcut() {
//    }
//
//    @Around("cachePointcut()")
//    public Object cacheAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        if (cache.containsKey(joinPoint.getArgs())) {
//            return cache.get(joinPoint.getArgs());
//        }
//        Object result = joinPoint.proceed();
//        cache.put(joinPoint.getArgs(), result);
//        return result;
//    }
//}

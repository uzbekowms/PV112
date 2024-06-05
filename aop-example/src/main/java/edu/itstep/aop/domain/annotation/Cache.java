package edu.itstep.aop.domain.annotation;


import org.springframework.web.bind.annotation.GetMapping;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
}

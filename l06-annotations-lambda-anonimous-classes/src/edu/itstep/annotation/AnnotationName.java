package edu.itstep.annotation;

import java.lang.annotation.*;

/**
 * Some annotation
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface AnnotationName {
    String value();

    String name() default "Petro";

}

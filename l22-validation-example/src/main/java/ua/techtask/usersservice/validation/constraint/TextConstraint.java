package ua.techtask.usersservice.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ua.techtask.usersservice.validation.validator.MinAgeValidator;
import ua.techtask.usersservice.validation.validator.TextValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TextValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TextConstraint {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

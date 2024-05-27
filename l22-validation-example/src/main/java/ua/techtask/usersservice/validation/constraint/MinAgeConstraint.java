package ua.techtask.usersservice.validation.constraint;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import lombok.Value;
import ua.techtask.usersservice.validation.validator.MinAgeValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MinAgeValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MinAgeConstraint {
    int minAge() default 0;
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

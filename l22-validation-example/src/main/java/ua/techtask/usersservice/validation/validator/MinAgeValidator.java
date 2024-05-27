package ua.techtask.usersservice.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ua.techtask.usersservice.validation.constraint.MinAgeConstraint;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class MinAgeValidator implements ConstraintValidator<MinAgeConstraint, LocalDate> {
    private int minAge;

    @Value("${validation.age.min}")
    private int defaultMinAge;

    @Override
    public void initialize(MinAgeConstraint constraintAnnotation) {
        this.minAge = constraintAnnotation.minAge() > 0 ? constraintAnnotation.minAge() : defaultMinAge;
    }

    @Override
    public boolean isValid(LocalDate birthday, ConstraintValidatorContext constraintValidatorContext) {
        if (birthday == null) {
            return false;
        }
        long age = LocalDate.from(birthday).until(LocalDate.now(), ChronoUnit.YEARS);
        return age > minAge;
    }
}

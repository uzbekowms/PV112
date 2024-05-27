package ua.techtask.usersservice.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ua.techtask.usersservice.validation.constraint.TextConstraint;

public class TextValidator implements ConstraintValidator<TextConstraint, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        return s.chars().allMatch(Character::isLetter);
    }
}

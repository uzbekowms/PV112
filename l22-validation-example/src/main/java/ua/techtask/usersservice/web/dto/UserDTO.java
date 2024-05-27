package ua.techtask.usersservice.web.dto;


import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.internal.constraintvalidators.bv.NotBlankValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import ua.techtask.usersservice.validation.constraint.MinAgeConstraint;
import ua.techtask.usersservice.validation.constraint.TextConstraint;
import ua.techtask.usersservice.validation.group.OnCreate;
import ua.techtask.usersservice.validation.group.OnUpdate;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    @Null
    private String id;

    @Email(groups = {OnCreate.class, OnUpdate.class}, message = "Email is not valid")
    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Email cannot be blank")
    private String email;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "First name cannot be blank")
    @TextConstraint(groups = {OnCreate.class, OnUpdate.class}, message = "Invalid name. Name cannot include special characters or digits")
    @Size(min = 2)
    private String firstName;

    @NotBlank(groups = {OnCreate.class, OnUpdate.class}, message = "Last name cannot be blank")
    @TextConstraint(groups = {OnCreate.class, OnUpdate.class}, message = "Invalid last name. Last name cannot include special characters or digits")
    @Size(min = 2)
    private String lastName;

    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "Birthdate cannot be blank")
    @Past(message = "Birthdate should be in the past", groups = {OnCreate.class, OnUpdate.class})
    @MinAgeConstraint(message = "User must be over 18 years old", groups = {OnCreate.class, OnUpdate.class})
    private LocalDate birthDate;

    private String address;

    private String phone;
}
//
//class Example {
//    @AssertFalse
//    private boolean isInvalid;
//    @AssertTrue
//    private boolean isValid;
//    @DecimalMax("100")
//    private double maxAmount;
//    @DecimalMin("10")
//    private double minAmount;
//
//    @Digits(integer = 5, fraction = 2)
//    @Email
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent
//    @Max(10)
//    @Min(10)
//    @Negative
//    @NegativeOrZero
//    @Positive
//    @PositiveOrZero
//    @NotBlank
//    @NotEmpty
//    @NotNull
//    @Null
//    //@Pattern()
//    @Size(min = 2, max = 10)
//    String message;
//
//}
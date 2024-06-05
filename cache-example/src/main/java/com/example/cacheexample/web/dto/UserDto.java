package com.example.cacheexample.web.dto;

import com.example.cacheexample.validation.ValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @Null(message = "You cannot provide id")
    private Long id;

    @NotBlank(groups = ValidationGroup.OnCreate.class, message = "Username cannot be empty")
    private String username;

    @NotBlank(groups = ValidationGroup.OnCreate.class, message = "Password cannot be empty")
    private String password;

    @NotBlank(groups = ValidationGroup.OnCreate.class, message = "Email cannot be empty")
    @Email(message = "Incorrect email format")
    private String email;
}

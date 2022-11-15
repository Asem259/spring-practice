package com.example.springpractice.model;


import javax.validation.constraints.*;

public record User(
        String id,
        @NotBlank
        String name,
        @Email
        String email,
        @Size(min = 6, max =36, message
                = "Password  must be between 6 and 36 characters")
        String password,
        @NotNull
        UserRole roles
) {

}
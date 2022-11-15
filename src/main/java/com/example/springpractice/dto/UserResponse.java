package com.example.springpractice.dto;

import javax.validation.constraints.*;

public record UserResponse(
        String id,
        @NotBlank
        String name,
        @Email
        String email
) {
}

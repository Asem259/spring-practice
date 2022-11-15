package com.example.springpractice.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public record Thing(
        String id,
        @NotNull
        @Max(value = 24)
        String desc,
        @NotNull
        String type
) {
}

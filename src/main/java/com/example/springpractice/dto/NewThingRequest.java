package com.example.springpractice.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public record NewThingRequest(
        @NotNull
        @Max(value = 24)
        String desc,
        @NotNull
        String type
) {
}

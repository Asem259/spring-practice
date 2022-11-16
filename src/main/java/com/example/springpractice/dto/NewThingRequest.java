package com.example.springpractice.dto;

import javax.validation.constraints.NotNull;

public record NewThingRequest(
        @NotNull
        String desc,
        @NotNull
        String type
) {
}

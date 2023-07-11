package com.alasgarov.simplerestapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePostRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String body;
}

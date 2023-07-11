package com.alasgarov.liquibasemigration.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePostRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String body;
}

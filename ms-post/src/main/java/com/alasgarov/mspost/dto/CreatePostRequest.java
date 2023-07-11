package com.alasgarov.mspost.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePostRequest {
    @NotBlank
    private Long userId;
    @NotBlank
    private String title;
    @NotBlank
    private String body;
}

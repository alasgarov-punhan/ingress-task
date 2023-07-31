package com.alasgarov.simplerestapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdatePostRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String body;
}

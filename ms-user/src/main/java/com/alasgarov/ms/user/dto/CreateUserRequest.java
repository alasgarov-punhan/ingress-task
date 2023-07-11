package com.alasgarov.ms.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserRequest {


    @NotBlank
    private String username;
}

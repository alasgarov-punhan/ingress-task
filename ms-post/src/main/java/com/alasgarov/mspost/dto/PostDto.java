package com.alasgarov.mspost.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostDto {
    private Long id;
    private Long userId;
    private String title;
    private String body;
    private LocalDate createdDate;
}

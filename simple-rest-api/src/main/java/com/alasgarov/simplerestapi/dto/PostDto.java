package com.alasgarov.simplerestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String body;
    private LocalDateTime createdDate;
}

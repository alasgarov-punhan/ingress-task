package com.alasgarov.mscar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDriverDto {
    private Long id;
    private String name;
    private int experience;
    private LocalDateTime createdDate;
}

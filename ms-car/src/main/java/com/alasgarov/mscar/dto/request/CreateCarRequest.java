package com.alasgarov.mscar.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {
    private String name;
    private Long driverId;
    private Long ownerId;
}

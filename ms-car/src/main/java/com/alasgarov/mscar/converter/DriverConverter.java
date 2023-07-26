package com.alasgarov.mscar.converter;

import com.alasgarov.mscar.dto.CarDriverDto;
import com.alasgarov.mscar.model.Driver;

public class DriverConverter {
    public static CarDriverDto convertEntityToCarDriverDto(Driver entity){
        return CarDriverDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .experience(entity.getExperience())
                .createdDate(entity.getCreatedDate())
                .build();
    }
}

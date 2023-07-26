package com.alasgarov.mscar.converter;

import com.alasgarov.mscar.dto.OwnerCarDto;
import com.alasgarov.mscar.dto.OwnerDto;
import com.alasgarov.mscar.model.Car;
import com.alasgarov.mscar.model.Owner;

import java.util.stream.Collectors;

public class OwnerConverter {
    public static OwnerCarDto convertCarToOwnerCarDto(Car entity){
        return OwnerCarDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public static OwnerDto convertEntityToOwnerDto(Owner entity){
        return OwnerDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .cars(entity.getCars()
                        .stream()
                        .map(OwnerConverter::convertCarToOwnerCarDto)
                        .collect(Collectors.toList()))
                .createdDate(entity.getCreatedDate())
                .build();
    }
}

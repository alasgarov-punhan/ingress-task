package com.alasgarov.mscar.converter;

import com.alasgarov.mscar.dto.CarDto;
import com.alasgarov.mscar.model.Car;

public class CarConverter {
    public static CarDto convertEntityToCarDto(Car entity){
        return CarDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .updateDate(entity.getUpdateDate())
                .build();
    }


}

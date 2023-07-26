package com.alasgarov.mscar.converter;

import com.alasgarov.mscar.dto.CarRepairCenterDto;
import com.alasgarov.mscar.model.CarRepairCenter;

public class CarRepairCenterConverter {
    public static CarRepairCenterDto convertEntityToCarRepairCenterDto(CarRepairCenter entity){
        return CarRepairCenterDto.builder()
                .name(entity.getName())
                .build();
    }

}

package com.alasgarov.mscar.service;

import com.alasgarov.mscar.converter.CarRepairCenterConverter;
import com.alasgarov.mscar.dto.CarRepairCenterDto;
import com.alasgarov.mscar.dto.request.CreateCarRepairCenterRequest;
import com.alasgarov.mscar.model.CarRepairCenter;
import com.alasgarov.mscar.repository.CarRepairCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarRepairCenterService {
    private final CarRepairCenterRepository carRepairCenterRepository;

    public void createCarRepairCenter(CreateCarRepairCenterRequest request){
        var entity = CarRepairCenter.builder()
                .name(request.getName())
                .build();
        carRepairCenterRepository.save(entity);
    }

    public List<CarRepairCenterDto> getAll(){
        return carRepairCenterRepository
                .findAll()
                .stream()
                .map(CarRepairCenterConverter::convertEntityToCarRepairCenterDto)
                .collect(Collectors.toList());
    }
}

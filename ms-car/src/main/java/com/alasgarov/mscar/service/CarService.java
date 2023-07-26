package com.alasgarov.mscar.service;

import com.alasgarov.mscar.dto.CarDto;
import com.alasgarov.mscar.dto.request.CreateCarRequest;
import com.alasgarov.mscar.model.Car;
import com.alasgarov.mscar.exception.ErrorCode;
import com.alasgarov.mscar.exception.GeneralException;
import com.alasgarov.mscar.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.alasgarov.mscar.converter.CarConverter.convertEntityToCarDto;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final OwnerService ownerService;
    private final DriverService driverService;

    public CarDto getCarById(Long id){
        var car = getCarIfExists(id);
        return convertEntityToCarDto(car);
    }

    private Car getCarIfExists(Long id){
        return carRepository.findById(id)
                .orElseThrow(
                        () -> new GeneralException(HttpStatus.NOT_FOUND ,
                                ErrorCode.CAR_NOT_FOUND.getCode(),
                                ErrorCode.CAR_NOT_FOUND.getMessage())
                );
    }


    public void addCar(CreateCarRequest request) {
        var owner = ownerService
                .getOwnerEntityById(request.getOwnerId());

        var driver = driverService
                .getDriverEntityById(request.getDriverId());

        var car = Car.builder()
                .name(request.getName())
                .driver(driver)
                .owner(owner)
                .build();

        carRepository.save(car);
    }
}

package com.alasgarov.mscar.service;

import com.alasgarov.mscar.dto.CarDriverDto;
import com.alasgarov.mscar.dto.request.CreateDriverRequest;
import com.alasgarov.mscar.exception.ErrorCode;
import com.alasgarov.mscar.exception.GeneralException;
import com.alasgarov.mscar.model.Car;
import com.alasgarov.mscar.model.Driver;
import com.alasgarov.mscar.repository.DriverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.alasgarov.mscar.converter.DriverConverter.convertEntityToCarDriverDto;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public CarDriverDto getDriverById(Long id){
        var driver = getDriverIfExists(id);
        return convertEntityToCarDriverDto(driver);
    }

    public Driver getDriverEntityById(Long id){
        return getDriverIfExists(id);
    }

    public void createDriver(CreateDriverRequest request){
        var driver = Driver.builder()
                .name(request.getName())
                .experience(request.getExperience())
                .build();
        driverRepository.save(driver);
    }

    private Driver getDriverIfExists(Long id){
        return driverRepository.findById(id)
                .orElseThrow(
                        () -> new GeneralException(HttpStatus.NOT_FOUND , ErrorCode.DRIVER_NOT_FOUND.getCode(),
                                ErrorCode.DRIVER_NOT_FOUND.getMessage())
                );
    }
}

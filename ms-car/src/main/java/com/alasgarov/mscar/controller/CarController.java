package com.alasgarov.mscar.controller;

import com.alasgarov.mscar.dto.CarDto;
import com.alasgarov.mscar.dto.request.CreateCarRequest;
import com.alasgarov.mscar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable Long id){
        return carService.getCarById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void createCar(@RequestBody CreateCarRequest createCarRequest){
        carService.addCar(createCarRequest);
    }



}

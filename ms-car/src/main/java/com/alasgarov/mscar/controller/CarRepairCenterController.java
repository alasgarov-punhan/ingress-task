package com.alasgarov.mscar.controller;

import com.alasgarov.mscar.dto.CarRepairCenterDto;
import com.alasgarov.mscar.dto.request.CreateCarRepairCenterRequest;
import com.alasgarov.mscar.service.CarRepairCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/car-repair-centers")
@RequiredArgsConstructor
public class CarRepairCenterController {
    private final CarRepairCenterService carRepairCenterService;

    @GetMapping
    public List<CarRepairCenterDto> getAllRepairCenter(){
        return carRepairCenterService.getAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void createRepairCenter(@RequestBody CreateCarRepairCenterRequest request){
        carRepairCenterService.createCarRepairCenter(request);
    }

}

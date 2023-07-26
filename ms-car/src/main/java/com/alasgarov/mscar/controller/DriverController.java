package com.alasgarov.mscar.controller;

import com.alasgarov.mscar.dto.CarDriverDto;
import com.alasgarov.mscar.dto.request.CreateDriverRequest;
import com.alasgarov.mscar.model.Driver;
import com.alasgarov.mscar.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("v1/drivers")
@RequiredArgsConstructor
public class DriverController {
    private final DriverService driverService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void createDriver(@RequestBody CreateDriverRequest request){
        driverService.createDriver(request);
    }


}

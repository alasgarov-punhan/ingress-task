package com.alasgarov.mscar.controller;

import com.alasgarov.mscar.dto.OwnerDto;
import com.alasgarov.mscar.dto.request.OwnerRequest;
import com.alasgarov.mscar.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("v1/owners")
@RequiredArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @GetMapping("/{id}")
    public OwnerDto getOwnerById(@PathVariable Long id){
        return ownerService.getOwnerById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void createOwner(@RequestBody OwnerRequest request){
        ownerService.creatOwner(request);
    }

//    @PatchMapping("/{id}/cars")
//    @ResponseStatus(NO_CONTENT)
//    public void addCarToOwner(@PathVariable Long id, @RequestParam Long carId){
//        ownerService.addCarToOwner(id, carId);
//    }
}

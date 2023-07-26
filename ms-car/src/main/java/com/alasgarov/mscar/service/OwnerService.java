package com.alasgarov.mscar.service;

import com.alasgarov.mscar.converter.OwnerConverter;
import com.alasgarov.mscar.dto.OwnerDto;
import com.alasgarov.mscar.dto.request.OwnerRequest;
import com.alasgarov.mscar.model.Car;
import com.alasgarov.mscar.model.Owner;
import com.alasgarov.mscar.exception.ErrorCode;
import com.alasgarov.mscar.exception.GeneralException;
import com.alasgarov.mscar.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.alasgarov.mscar.converter.OwnerConverter.convertEntityToOwnerDto;

@Service
@RequiredArgsConstructor
public class OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerDto getOwnerById(Long id){
        var owner = getOwnerIfExists(id);
        return convertEntityToOwnerDto(owner);
    }

    public Owner getOwnerEntityById(Long id){
        return getOwnerIfExists(id);
    }

    public void creatOwner(OwnerRequest request){
        var owner = Owner.builder()
                .name(request.getName())
                .build();
        ownerRepository.save(owner);
    }

/*    public void addCarToOwner(Long id, Long carId){
        var owner = getOwnerIfExists(id);
        var cars = owner.getCars();

        var car = carService.getCarById(carId);
        cars.add(Car.builder().id(car.getId()).name(car.getName()).build());

        owner.setCars(cars);
        ownerRepository.save(owner);
    }*/

    private Owner getOwnerIfExists(Long id){
        return ownerRepository.findById(id)
                .orElseThrow(
                        () -> new GeneralException(HttpStatus.NOT_FOUND , ErrorCode.OWNER_NOT_FOUND.getCode(),
                                ErrorCode.OWNER_NOT_FOUND.getMessage())
                );
    }
}

package com.alasgarov.mscar.service

import com.alasgarov.mscar.model.Car
import com.alasgarov.mscar.exception.ErrorCode
import com.alasgarov.mscar.exception.GeneralException
import com.alasgarov.mscar.repository.CarRepository
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class CarServiceTest extends Specification {
    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()
    private CarRepository carRepository
    private OwnerService ownerService
    private DriverService driverService
    private CarService carService

    def setup(){
        carRepository = Mock()
        ownerService = Mock()
        driverService = Mock()
        carService = new CarService(carRepository, ownerService, driverService)
    }

    def "TestGetCarById success case"(){
        given:
        def id= random.nextObject(Long)
        def entity = random.nextObject(Car)

        when:
        def actual = carService.getCarById(id)

        then:
        1 * carRepository.findById(id) >> Optional.of(entity)
        actual.id == entity.id
        actual.name == entity.name  
    }

    def "TestGetCarById CAR_NOT_FOUND case"(){
        given:
        def id = random.nextObject(Long)

        when:
        carService.getCarById(id)

        then:
        1 * carRepository.findById(id) >> Optional.empty()
        GeneralException exception = thrown()
        exception.getErrorCode() == ErrorCode.CAR_NOT_FOUND.getCode()
        exception.getMessage() == ErrorCode.CAR_NOT_FOUND.getMessage()
    }


}

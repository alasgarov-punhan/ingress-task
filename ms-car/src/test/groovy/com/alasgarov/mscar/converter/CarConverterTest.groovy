package com.alasgarov.mscar.converter


import com.alasgarov.mscar.model.Car
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

import static com.alasgarov.mscar.converter.CarConverter.convertEntityToCarDto

class CarConverterTest extends Specification {
    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    def "TestConvertEntityToCarDto"() {
        given:
        def entity = random.nextObject(Car)

        when:
        def actual = convertEntityToCarDto(entity)

        then:
        actual.id == entity.id
        actual.name == entity.name
        actual.updateDate == entity.updateDate
    }

}

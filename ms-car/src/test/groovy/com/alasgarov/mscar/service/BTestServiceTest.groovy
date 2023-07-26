package com.alasgarov.mscar.service

import spock.lang.Specification
import spock.lang.Unroll

import static com.alasgarov.mscar.service.BTestService.multiplication

class BTestServiceTest extends Specification {

    @Unroll
    def "TestMultiplication"(){
        given:
        def a = first
        def b = second

        when:
        def actual = multiplication(a, b)

        then:
        actual == multiplication

        where:
        first   |second     |multiplication
        1       |10         |10
        2       |20         |40
        10      |10         |100
        100     |3          |300
    }
}

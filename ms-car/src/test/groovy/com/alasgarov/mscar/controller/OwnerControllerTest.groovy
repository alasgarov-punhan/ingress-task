package com.alasgarov.mscar.controller

import com.alasgarov.mscar.dto.OwnerCarDto
import com.alasgarov.mscar.dto.OwnerDto
import com.alasgarov.mscar.service.OwnerService
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import java.time.LocalDateTime

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class OwnerControllerTest extends Specification {
    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()
    private OwnerService ownerService
    private MockMvc mockMvc

    void setup(){
        ownerService = Mock()
        def ownerController  = new OwnerController(ownerService)
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController)
            .build()
    }


    def "TestGetOwnerById"(){
        given:
        def id = random.nextObject(Long)
        def url = "v1/owners/$id"

        def dataResponse = new OwnerDto(1L, "punhan",
                new OwnerCarDto(1L, "BMW") as List<OwnerCarDto>,
                LocalDateTime.of(
                        2023,
                        7,
                        24,
                        10,
                        8,
                        2))

        def expectedResponse = """
                                            {
                                                "id": 1,
                                                "name": "punhan",
                                                "createdDate" : [2023, 7, 23, 10, 8, 2],
                                                "cars": [
                                                    {
                                                        "id": 10,
                                                        "name": "BMW"
                                                    }
                                                ]                                                    
                                            }
                                      """

        when:
        def result = mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON)).andReturn()


        then:
        1 * ownerService.getOwnerById(id) >> dataResponse

        result.response.status == HttpStatus.OK.value()
        JSONAssert.assertEquals(expectedResponse, result.response.contentAsString, true)
    }

}

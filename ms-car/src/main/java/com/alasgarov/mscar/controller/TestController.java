package com.alasgarov.mscar.controller;

import com.alasgarov.mscar.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/tests")
@RequiredArgsConstructor
public class TestController {
    @Qualifier("BTestService")  private final TestService testService;

    @PostMapping
    public void doSomething(){
        testService.doSomething();
    }
}

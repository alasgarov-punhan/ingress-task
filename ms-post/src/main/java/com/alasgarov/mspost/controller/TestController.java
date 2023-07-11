package com.alasgarov.mspost.controller;

import com.alasgarov.mspost.dto.PostDto;
import com.alasgarov.mspost.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class TestController {
    private final TestService testService;


    @GetMapping("/internal-call")
    void get(){
        testService.savePostTest();
    }

    @GetMapping("/direct-call")
    void getDirect(){
        testService.savePost();
    }
}

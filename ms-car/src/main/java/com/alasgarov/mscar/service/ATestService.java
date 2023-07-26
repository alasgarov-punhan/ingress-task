package com.alasgarov.mscar.service;

import org.springframework.stereotype.Service;

@Service
public class ATestService implements TestService{
    @Override
    public void doSomething() {
        System.out.println("ATestService");
    }
}

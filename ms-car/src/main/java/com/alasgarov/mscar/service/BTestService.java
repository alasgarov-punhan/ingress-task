package com.alasgarov.mscar.service;

import org.springframework.stereotype.Service;

@Service
public class BTestService implements TestService{
    @Override
    public void doSomething() {
        System.out.println("BTestService");
    }

    public static int multiplication(int a, int b){
        return a * b;
    }
}

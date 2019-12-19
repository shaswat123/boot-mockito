package com.mock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockitoHelloWorldController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World !";
    }

}

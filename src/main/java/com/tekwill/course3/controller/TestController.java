package com.tekwill.course3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("api/test")
    public String testEndpoint(){
        return "Hello World!";
    }
}

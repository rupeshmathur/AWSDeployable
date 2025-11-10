package com.cloud.AWSDeployable.AWSDeployable.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aws")
public class HelloController {

    @GetMapping("/sayHello")
    public String respond() {
        return "Hello from Rupesh  !!";
    }
}

package com.nkiem.demo_helloSpringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSpringController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello spring boot 3";
    }
}

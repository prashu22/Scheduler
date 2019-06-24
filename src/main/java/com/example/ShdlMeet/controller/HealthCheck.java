package com.example.ShdlMeet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/health", method = RequestMethod.GET)
public class HealthCheck {


    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "healty";
    }

}

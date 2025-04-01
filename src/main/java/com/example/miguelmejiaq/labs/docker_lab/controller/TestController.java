package com.example.miguelmejiaq.labs.docker_lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miguelmejiaq.labs.docker_lab.response.InfoResponse;

@RestController
@RequestMapping("/api/info")
public class TestController {
    @Value("${environment.name}")
    String environment;

    @Autowired
    BuildProperties buildProperties;

    TestController(){}

    @GetMapping("/")
    InfoResponse getEnvironment(){
        return InfoResponse.builder().environment(environment).version(buildProperties.getVersion()).build();
    }
}

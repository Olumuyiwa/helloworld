package com.poc.helloworld.controller;

import com.poc.helloworld.service.HelloWorldService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;


@RestController
@RequestMapping("/helloworld")
public class HelloWorldController {
    private static final Logger logger = 	LoggerFactory.getLogger(HelloWorldController.class);


    @Autowired
    private HelloWorldService helloWorldService;
    //    /helloworld/greet
    @GetMapping(path = "/greet")
    public ResponseEntity<String> greetAsJson() {
        logger.info("greetAsJson request received at '{}'", new Date().toString());

        JSONObject jsonObject = helloWorldService.fetchRightGreeting();

        return ResponseEntity.ok(jsonObject.toString());
    }
    //    /helloworld/sayhi
    @GetMapping(path = "/sayhi")
    public String greetAsString() {
        logger.info("greetAsString request received at '{}'.", new Date());
        return helloWorldService.getTimeOfDay();
    }
    @GetMapping(path = "/blank")
    public String blank() {
        logger.info("blank '{}'.", new Date());
        return "Blank - " + helloWorldService.getTimeOfDay();
    }
}

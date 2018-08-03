package com.gzdx.test.spring.springboot.controller;

import com.gzdx.test.spring.springboot.domain.DemoReq;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DemoController {

    @Value("${.blog.value}")
    private String randomValue;

    @Value("${.blog.number}")
    private int randomNumber;

    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public String demo() {
        return "hello,SpringBoot!" + randomValue + "=====" + randomNumber;
    }

    @GetMapping("/demo/valid")
    public String demoValid(@Valid DemoReq req) {
        return req.getCode() + "," + req.getName();
    }

    @GetMapping("/mock")
    public String mockDemo(String msg) {
        return msg;
    }
}

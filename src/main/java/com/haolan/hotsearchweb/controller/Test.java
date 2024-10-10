package com.haolan.hotsearchweb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @RequestMapping("/test")
    public String test(){
        System.out.println("hello world");
        return "hello world";
    }
}

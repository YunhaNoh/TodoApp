package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test") //주소 클래스에 붙임
public class TestController {
    @GetMapping("/testGetMapping") //주소 메서드에 붙임
    public String testController(){

        return "Hello World, 노윤하";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id){
        return "Hello World, 노윤하 " + id;
    }
}

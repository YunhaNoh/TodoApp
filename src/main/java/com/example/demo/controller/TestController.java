package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/TestRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id){
        return "Hello World! ID " + id;
    }

    @GetMapping("/TestRequestBody")
    public String testControllerRequestParam(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return "Hello World! 노윤하. id: " + testRequestBodyDTO.getId() +", message: "
                +testRequestBodyDTO.getMessage();
    }

    @GetMapping("/TestResponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("nyh");
        list.add("nyh2");
        list.add("nyh3");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }
    @GetMapping("/TestResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String> list = new ArrayList<>();
        list.add("nyh");
        list.add("nyh2");
        list.add("nyh3");

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        //return ResponseEntity.ok().body(response);
        return ResponseEntity.badRequest().body(response);
    }
}

package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/test")
    public ResponseEntity<?> testTodo() {
        String str = service.testService(); //테스트 서비스 사용
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        return ResponseEntity.ok().body(response);
    }
}
    /*
    @GetMapping("/testTodo")
    public ResponseEntity<?> testTodo(){
        List<String> list = new ArrayList<>();
        list.add("nyh");
        list.add("nyh2");
        list.add("nyh3");

        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();

        //return ResponseEntity.ok().body(response);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/TestRequestBody")
    public String testControllerRequestParam(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return "Hello World! 노윤하. id: " + testRequestBodyDTO.getId() +", message: "
                +testRequestBodyDTO.getMessage();
    }
    */


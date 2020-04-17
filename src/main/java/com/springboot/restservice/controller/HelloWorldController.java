package com.springboot.restservice.controller;

import com.springboot.restservice.model.UserDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/*
@Author : Yogesh Deshmukh
*/
@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> testMethod(@PathVariable("name")String name){
        return ResponseEntity.ok("Hello "+name);
    }

    @GetMapping("/user/{firstname}/{lastname}")
    public UserDetail getUserDetails(@PathVariable("firstname")String firstname, @PathVariable("lastname")String lastname,
    @RequestParam("city")String city){
        return new UserDetail(firstname,lastname,city);
    }

}

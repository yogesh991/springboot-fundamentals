package com.springboot.restservice.controller;

import com.springboot.restservice.entity.User;
import com.springboot.restservice.model.UserDetail;
import com.springboot.restservice.util.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


/*
@Author : Yogesh Deshmukh
*/
@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @Autowired
    private EmailServiceImpl emailService;

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> testMethod(@PathVariable("name")String name){
        return ResponseEntity.ok("Hello "+name);
    }

    @GetMapping("/user/{firstname}/{lastname}")
    public UserDetail getUserDetails(@PathVariable("firstname")String firstname, @PathVariable("lastname")String lastname,
    @RequestParam("city")String city){
        return new UserDetail(firstname,lastname,city);
    }

    @GetMapping("/mail/{subject}")
    public ResponseEntity<Void> mailTest(@PathVariable("subject")String subject, @RequestParam("email") String email, UriComponentsBuilder builder){
        emailService.sendEmail(email,subject);
        HttpHeaders header = new HttpHeaders();
        header.setLocation(builder.path("/user/{subject}").buildAndExpand(email).toUri());
        return new ResponseEntity<Void>(header, HttpStatus.ACCEPTED);
    }

}

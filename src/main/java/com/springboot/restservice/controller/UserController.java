package com.springboot.restservice.controller;

import com.springboot.restservice.entity.User;
import com.springboot.restservice.exceptions.UserExistsException;
import com.springboot.restservice.exceptions.UserNotFoundException;
import com.springboot.restservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

/*
@Author : Yogesh Deshmukh
*/

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder){
        try {
             userService.createUser(user);
             HttpHeaders header = new HttpHeaders();
             header.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
             return new ResponseEntity<Void>(header,HttpStatus.CREATED);
        } catch (UserExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Optional<User>  getUserById(@PathVariable("id") Long id){
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id")Long id, @RequestBody User user){
        try {
            return userService.updateUserById(id,user);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    @GetMapping("/by-username/{username}")
    public User findByUserName(@PathVariable("username") String username){
        return userService.findUserByUserName(username);
    }

}

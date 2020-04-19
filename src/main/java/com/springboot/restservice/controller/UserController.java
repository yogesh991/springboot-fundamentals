package com.springboot.restservice.controller;

import com.springboot.restservice.entity.User;
import com.springboot.restservice.exceptions.UserExistsException;
import com.springboot.restservice.exceptions.UserNameNotFoundException;
import com.springboot.restservice.exceptions.UserNotFoundException;
import com.springboot.restservice.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/*
@Author : Yogesh Deshmukh
*/

@RestController
@Validated
@RequestMapping("/user")
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserServiceImpl userService;


    @GetMapping("/all")
    public List<User> getAllUsers(){
        log.info("Inside Get All users Controller");
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public ResponseEntity<Void> createUser(@Valid @RequestBody User user, UriComponentsBuilder builder){
        log.info("Inside Create User Controller method");
        try {
             userService.createUser(user);
             HttpHeaders header = new HttpHeaders();
             header.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
             return new ResponseEntity<Void>(header,HttpStatus.CREATED);
        } catch (UserExistsException e) {
            log.info("UserAlreadyExist Exception for ID : "+user.getId());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Optional<User>  getUserById(@PathVariable("id") @Min(1) Long id){
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
    public User findByUserName(@PathVariable("username") String username) throws UserNameNotFoundException {
        User user = userService.findUserByUserName(username);
        if(user == null)
            throw new UserNameNotFoundException("UserName doesn't exist in DB, username : "+username);
        return user;
    }
























}

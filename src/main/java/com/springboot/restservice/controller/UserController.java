package com.springboot.restservice.controller;

import com.springboot.restservice.entity.User;
import com.springboot.restservice.service.UserServiceImpl;
import com.springboot.restservice.utils.UserNotPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        Optional<User> user = userService.getUserById(id);
            if(user.isPresent())
                return user.get();
            else
                throw new UserNotPresentException("User doesn't exist :"+id);
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable("id")Long id, @RequestBody User user){
        return userService.updateUserById(id,user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return "Successfully Deleted !!";
    }

    @GetMapping("/by-username/{username}")
    public User findByUserName(@PathVariable("username") String username){
        return userService.findUserByUserName(username);
    }

}

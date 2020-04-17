package com.springboot.restservice.service;

import com.springboot.restservice.entity.User;
import com.springboot.restservice.exceptions.UserExistsException;
import com.springboot.restservice.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;


/*
@Author : Yogesh Deshmukh
*/
public interface UserService {

    public List<User> getAllUsers();

    public User createUser(User user) throws UserExistsException;

    public Optional<User> getUserById(long id) throws UserNotFoundException;

    public User updateUserById(Long id, User user) throws UserNotFoundException;

    public  void deleteUserById(Long id) ;

    public User findUserByUserName(String username);
}

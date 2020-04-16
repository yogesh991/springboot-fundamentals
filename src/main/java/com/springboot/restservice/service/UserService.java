package com.springboot.restservice.service;

import com.springboot.restservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();

    public User createUser(User user);

    public Optional<User> getUserById(long id);

    public User updateUserById(Long id, User user);

    public  void deleteUserById(Long id);

    public User findUserByUserName(String username);
}

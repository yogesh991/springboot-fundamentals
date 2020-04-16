package com.springboot.restservice.service;

import com.springboot.restservice.entity.User;
import com.springboot.restservice.repository.UserRepository;
import com.springboot.restservice.utils.UserNotPresentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUserById(Long id, User user) {
        //Check first user exist or not ?
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        if(userRepository.getOne(id) != null){
            userRepository.deleteById(id);
        }
        else
            throw new UserNotPresentException(id+" User doesn't exist !!");
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}

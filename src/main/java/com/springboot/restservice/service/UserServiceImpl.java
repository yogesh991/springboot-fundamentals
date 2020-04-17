package com.springboot.restservice.service;

import com.springboot.restservice.entity.User;
import com.springboot.restservice.exceptions.UserExistsException;
import com.springboot.restservice.exceptions.UserNotFoundException;
import com.springboot.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/*
@Author : Yogesh Deshmukh
*/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) throws UserExistsException{
        User existingUser = userRepository.findByUsername(user.getUsername());
        if(existingUser != null)
            throw new UserExistsException("User already exists with the UserName : "+user.getUsername());
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(long id) throws UserNotFoundException{
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent())
            throw new UserNotFoundException(" UserID : " +id+" Not found in Database !! ");
        return user;
    }

    @Override
    public User updateUserById(Long id, User user) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if(!optionalUser.isPresent())
            throw new UserNotFoundException(" UserID : " +id+" Not found in Database !! ");

        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        }
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User id : "+id+" NOT found in User Repository");
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}

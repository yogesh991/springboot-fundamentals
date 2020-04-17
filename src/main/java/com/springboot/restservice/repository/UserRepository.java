package com.springboot.restservice.repository;


import com.springboot.restservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
@Author : Yogesh Deshmukh
*/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}

package com.springboot.restservice.util;/*
@Author : Yogesh Deshmukh
*/

import com.springboot.restservice.entity.User;

public interface EmailService {
    public void sendEmail(String email, String subject);
}

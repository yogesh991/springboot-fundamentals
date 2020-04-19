package com.springboot.restservice.util;
/*
@Author : Yogesh Deshmukh
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class MailContentBuilder {

    @Autowired
    private SpringTemplateEngine templateEngine;

    public String build(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        return templateEngine.process("MailTemplate", context);
    }
}
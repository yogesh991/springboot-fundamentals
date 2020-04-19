package com.springboot.restservice.util;
/*
@Author : Yogesh Deshmukh
*/

import com.springboot.restservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    private static final Logger log = Logger.getLogger(EmailServiceImpl.class.getName());

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private MailContentBuilder mailContentBuilder;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Async
    public void sendEmail(String email, String subject) {
        log.info(" inside the sendMail method ");
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(mailFrom);
            messageHelper.setTo(email);
            messageHelper.setSubject(subject);
            String content = mailContentBuilder.build(email);
            messageHelper.setText(content, true);
        };
        try{
            mailSender.send(messagePreparator);
            log.info("Mail has sent successfully");
        } catch (MailException e) {
            log.warning("Failed to send Email : " + e.getMessage());
        }
    }
}

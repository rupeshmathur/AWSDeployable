package com.cloud.AWSDeployable.AWSDeployable.service;

import com.cloud.AWSDeployable.AWSDeployable.model.ChannelInterface;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailChannel implements ChannelInterface {

    private final JavaMailSender mailSender;
    public EmailChannel(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendMessage(String from, String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}

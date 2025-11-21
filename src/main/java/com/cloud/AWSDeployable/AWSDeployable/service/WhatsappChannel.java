package com.cloud.AWSDeployable.AWSDeployable.service;

import com.cloud.AWSDeployable.AWSDeployable.model.ChannelInterface;
import org.springframework.stereotype.Service;

@Service
public class WhatsappChannel implements ChannelInterface {


    @Override
    public void sendMessage(String from, String to, String subject, String body) {
       /* Message message = Message.creator(
                new PhoneNumber("whatsapp:" + to), // recipient number
                new PhoneNumber(fromNumber),             // Twilio sandbox number
                body
        ).create();*/

        System.out.println("WhatsApp message sent! SID: " );
    }
}

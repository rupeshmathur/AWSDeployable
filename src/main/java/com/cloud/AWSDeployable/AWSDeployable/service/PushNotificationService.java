package com.cloud.AWSDeployable.AWSDeployable.service;

import com.cloud.AWSDeployable.AWSDeployable.entities.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {

    public WhatsappChannel whatsappChannel;
    public EmailChannel emailChannel;

    @Value("${spring.mail.username}")
    private String fromUser;
    @Autowired
    public PushNotificationService(WhatsappChannel whatsappChannel, EmailChannel emailChannel) {
        this.whatsappChannel = whatsappChannel;
        this.emailChannel = emailChannel;
    }

    @Async("internalThreadPoolTaskExecutor")
    public void sendDailyNotification(UserDetails user, String message) {
        if (user.isPhoneSameAsWhatsapp() && user.getNotificationFrequencies().contains("Daily")) {
            if (user.isPhoneSameAsWhatsapp()) {
                emailChannel.sendMessage(fromUser,user.getEmail(),"Daily Digest",message);
                System.out.println("📲 Sending DAILY Email Message " + message + " to " + user.getEmail());
            } else {
                System.out.println("📩 Sending DAILY Email Message: " + message + " to " + user.getEmail());
            }
        }
    }

    public void sendWeeklyNotification(UserDetails user) {
        if (user.isPhoneSameAsWhatsapp() && user.getNotificationFrequencies().contains("Weekly")) {
            System.out.println("📧 Sending WEEKLY email to: " + user.getEmail());
            if (user.isPhoneSameAsWhatsapp()) {
                System.out.println("📲 Sending WEEKLY WhatsApp message to: " + user.getPhone());
            }
        }
    }

    public void sendMonthlyNotification(UserDetails user) {
        if (user.isPhoneSameAsWhatsapp() && user.getNotificationFrequencies().contains("Monthly")) {
            String targetEmail = user.isWorkEmailProvided() ? user.getWorkEmail() : user.getEmail();
            System.out.println("📅 Sending MONTHLY email to: " + targetEmail);
        }
    }

    public void sendYearlyNotification(UserDetails user) {
        if (user.isPhoneSameAsWhatsapp() && user.getNotificationFrequencies().contains("Yearly")) {
            System.out.println("🎉 Sending YEARLY email to: " + user.getEmail());
        }
    }
}

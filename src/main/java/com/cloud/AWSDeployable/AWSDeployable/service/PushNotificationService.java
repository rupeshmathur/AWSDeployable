package com.cloud.AWSDeployable.AWSDeployable.service;

import com.cloud.AWSDeployable.AWSDeployable.entities.UserDetails;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {

    @Async("internalThreadPoolTaskExecutor")
    public void sendDailyNotification(UserDetails user, String message) {
        if (user.isWhatsapp() && user.getNotificationFrequencies().contains("Daily")) {
            if (user.isWhatsapp()) {
                System.out.println("📲 Sending DAILY WhatsApp message " + message + " to " + user.getPhone());
            } else {
                System.out.println("📩 Sending DAILY SMS to: " + message + " to " + user.getPhone());
            }
        }
    }

    public void sendWeeklyNotification(UserDetails user) {
        if (user.isWhatsapp() && user.getNotificationFrequencies().contains("Weekly")) {
            System.out.println("📧 Sending WEEKLY email to: " + user.getEmail());
            if (user.isWhatsapp()) {
                System.out.println("📲 Sending WEEKLY WhatsApp message to: " + user.getPhone());
            }
        }
    }

    public void sendMonthlyNotification(UserDetails user) {
        if (user.isWhatsapp() && user.getNotificationFrequencies().contains("Monthly")) {
            String targetEmail = user.isWorkEmailProvided() ? user.getWorkEmail() : user.getEmail();
            System.out.println("📅 Sending MONTHLY email to: " + targetEmail);
        }
    }

    public void sendYearlyNotification(UserDetails user) {
        if (user.isWhatsapp() && user.getNotificationFrequencies().contains("Yearly")) {
            System.out.println("🎉 Sending YEARLY email to: " + user.getEmail());
        }
    }
}

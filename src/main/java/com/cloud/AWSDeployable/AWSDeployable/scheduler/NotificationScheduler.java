package com.cloud.AWSDeployable.AWSDeployable.scheduler;

import com.cloud.AWSDeployable.AWSDeployable.builder.NotificationTemplateBuilder;
import com.cloud.AWSDeployable.AWSDeployable.constants.SubscriptionType;
import com.cloud.AWSDeployable.AWSDeployable.entities.UserDetails;
import com.cloud.AWSDeployable.AWSDeployable.repository.UserDetailsRepository;
import com.cloud.AWSDeployable.AWSDeployable.service.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class NotificationScheduler {

    private final PushNotificationService pushNotificationService;
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public NotificationScheduler(PushNotificationService pushNotificationService,UserDetailsRepository userDetailsRepository) {
        this.pushNotificationService = pushNotificationService;
        this.userDetailsRepository = userDetailsRepository;
    }

    // 🕖 Every day at 7 AM
    @Scheduled(cron = "0 04 22 * * *")
    public void sendDailyNotifications() {
        Optional<List<UserDetails>> users = userDetailsRepository.isSubscribedForDaily();
        if(users.isEmpty()){
            System.out.println("No user subscribed for daily notifications");
        }
        users.get().forEach(user -> {
            String msg = new NotificationTemplateBuilder()
                    .withUser(user)
                    .withType(SubscriptionType.DAILY)
                    .build();

            pushNotificationService.sendDailyNotification(user,msg);
        });
    }

/*    // 🕘 Every Monday at 9 AM
    @Scheduled(cron = "0 0 9 * * MON")
    public void sendWeeklyNotifications() {
        List<UserDetails> users = notificationService.getSubscribedUsers(SubscriptionType.WEEKLY);
        users.forEach(user -> {
            String msg = new NotificationTemplateBuilder()
                    .withUser(user)
                    .withType(SubscriptionType.WEEKLY)
                    .build();

            notificationService.sendEmail(user.getEmail(), msg);
            if (user.isWhatsapp()) {
                notificationService.sendWhatsapp(user.getPhone(), msg);
            }
        });
    }

    // 🗓️ First day of every month at 9 AM
    @Scheduled(cron = "0 0 9 1 * *")
    public void sendMonthlyNotifications() {
        List<UserDetails> users = notificationService.getSubscribedUsers(SubscriptionType.MONTHLY);
        users.forEach(user -> {
            String msg = new NotificationTemplateBuilder()
                    .withUser(user)
                    .withType(SubscriptionType.MONTHLY)
                    .build();

            if (user.getWorkEmail() != null && !user.getWorkEmail().isEmpty()) {
                notificationService.sendEmail(user.getWorkEmail(), msg);
            } else {
                notificationService.sendEmail(user.getEmail(), msg);
            }
        });
    }

    // 🎉 1st January every year
    @Scheduled(cron = "0 0 9 1 1 *")
    public void sendYearlyNotifications() {
        List<UserDetails> users = notificationService.getSubscribedUsers(SubscriptionType.YEARLY);
        users.forEach(user -> {
            String msg = new NotificationTemplateBuilder()
                    .withUser(user)
                    .withType(SubscriptionType.YEARLY)
                    .build();

            notificationService.sendEmail(user.getEmail(), msg);
        });
    }*/
}

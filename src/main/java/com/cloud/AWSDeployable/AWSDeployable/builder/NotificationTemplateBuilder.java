package com.cloud.AWSDeployable.AWSDeployable.builder;


import com.cloud.AWSDeployable.AWSDeployable.constants.SubscriptionType;
import com.cloud.AWSDeployable.AWSDeployable.entities.UserDetails;

public class NotificationTemplateBuilder {

    private String name;
    private String message;
    private SubscriptionType type;

    public NotificationTemplateBuilder withUser(UserDetails userDetails) {
        this.name = userDetails.getName();
        return this;
    }

    public NotificationTemplateBuilder withType(SubscriptionType type) {
        this.type = type;
        return this;
    }

    public NotificationTemplateBuilder withMessage(String message) {
        this.message = message;
        return this;
    }

    public String build() {
        String greeting = "Hello " + name + ",";
        String body = switch (type) {
            case DAILY -> "Here’s your daily update!";
            case WEEKLY -> "Here’s your weekly summary!";
            case MONTHLY -> "Your monthly insights are ready!";
            case YEARLY -> "Happy New Year! Here’s your yearly recap!";
        };
        return greeting + "\n\n" + (message != null ? message : body) + "\n\nRegards,\nYour Notification Team";
    }
}

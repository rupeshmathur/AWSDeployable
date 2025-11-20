package com.cloud.AWSDeployable.AWSDeployable.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "user_details")
public class UserDetails {

    @Id
    private String id;

    private String name;
    private String email;
    private String phone;
    private boolean isPhoneSameAsWhatsapp;
    private boolean subscribeNotifications;

    private boolean workEmailProvided;
    private String workEmail;

    // e.g., ["DAILY", "WEEKLY"] – store selected frequencies
    private List<String> notificationFrequencies;

    public UserDetails() {}

    public UserDetails(String name, String email, String phone, boolean isPhoneSameAsWhatsapp,
                       boolean subscribeNotifications, boolean workEmailProvided, String workEmail,
                       List<String> notificationFrequencies) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.isPhoneSameAsWhatsapp = isPhoneSameAsWhatsapp;
        this.subscribeNotifications = subscribeNotifications;
        this.workEmailProvided = workEmailProvided;
        this.workEmail = workEmail;
        this.notificationFrequencies = notificationFrequencies;
    }

    // 🔹 Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isPhoneSameAsWhatsapp() {
        return isPhoneSameAsWhatsapp;
    }

    public void setPhoneSameAsWhatsapp(boolean phoneSameAsWhatsapp) {
        this.isPhoneSameAsWhatsapp = phoneSameAsWhatsapp;
    }

    public boolean isSubscribeNotifications() {
        return subscribeNotifications;
    }

    public void setSubscribeNotifications(boolean subscribeNotifications) {
        this.subscribeNotifications = subscribeNotifications;
    }

    public boolean isWorkEmailProvided() {
        return workEmailProvided;
    }

    public void setWorkEmailProvided(boolean workEmailProvided) {
        this.workEmailProvided = workEmailProvided;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public List<String> getNotificationFrequencies() {
        return notificationFrequencies;
    }

    public void setNotificationFrequencies(List<String> notificationFrequencies) {
        this.notificationFrequencies = notificationFrequencies;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", whatsapp=" + isPhoneSameAsWhatsapp +
                ", subscribeNotifications=" + subscribeNotifications +
                ", workEmailProvided=" + workEmailProvided +
                ", workEmail='" + workEmail + '\'' +
                ", notificationFrequencies=" + notificationFrequencies +
                '}';
    }
}

package com.cloud.AWSDeployable.AWSDeployable.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserDetailsDTO {

    private String name;
    private String email;
    private String phone;

    @JsonProperty("isPhoneSameAsWhatsapp") // maps JSON field to Java field
    private boolean isPhoneSameAsWhatsapp;

    @JsonProperty("isWorkEmailProvided")
    private boolean isWorkEmailProvided;

    private String workEmail;

    @JsonProperty("subscribeNotifications")
    private boolean subscribeNotifications;

    private List<String> notificationFrequency;

    // getters and setters
    public boolean isPhoneSameAsWhatsapp() {
        return isPhoneSameAsWhatsapp;
    }

    public void setPhoneSameAsWhatsapp(boolean phoneSameAsWhatsapp) {
        this.isPhoneSameAsWhatsapp = phoneSameAsWhatsapp;
    }

    public boolean isWorkEmailProvided() {
        return isWorkEmailProvided;
    }

    public void setWorkEmailProvided(boolean workEmailProvided) {
        this.isWorkEmailProvided = workEmailProvided;
    }

    public boolean isSubscribeNotifications() {
        return subscribeNotifications;
    }

    public void setSubscribeNotifications(boolean subscribeNotifications) {
        this.subscribeNotifications = subscribeNotifications;
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

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public List<String> getNotificationFrequency() {
        return notificationFrequency;
    }

    public void setNotificationFrequency(List<String> notificationFrequency) {
        this.notificationFrequency = notificationFrequency;
    }

    @Override
    public String toString() {
        return "UserDetailsDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isPhoneSameAsWhatsapp=" + isPhoneSameAsWhatsapp +
                ", isWorkEmailProvided=" + isWorkEmailProvided +
                ", workEmail='" + workEmail + '\'' +
                ", subscribeNotifications=" + subscribeNotifications +
                ", notificationFrequency=" + notificationFrequency +
                '}';
    }
}

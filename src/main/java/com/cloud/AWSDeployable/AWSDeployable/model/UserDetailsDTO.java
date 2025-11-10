package com.cloud.AWSDeployable.AWSDeployable.model;

import java.util.List;

public class UserDetailsDTO {
    private String name;
    private String email;
    private String phone;
    private boolean isPhoneSameAsWhatsapp;
    private boolean isWorkEmailProvided;
    private String workEmail;
    private boolean isSubscribed;
    private List<String> notificationFrequency;

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
        isPhoneSameAsWhatsapp = phoneSameAsWhatsapp;
    }

    public boolean isWorkEmailProvided() {
        return isWorkEmailProvided;
    }

    public void setWorkEmailProvided(boolean workEmailProvided) {
        this.isWorkEmailProvided = workEmailProvided;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        this.isSubscribed = subscribed;
    }

    public List<String> getNotificationFrequency() {
        return notificationFrequency;
    }

    public void setNotificationFrequency(List<String> notificationFrequency) {
        this.notificationFrequency = notificationFrequency;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isWhatsApp=" + isPhoneSameAsWhatsapp +
                ", wantsWorkEmail=" + isWorkEmailProvided +
                ", workEmail='" + workEmail + '\'' +
                ", subscribe=" + isSubscribed +
                ", frequency=" + notificationFrequency +
                '}';
    }
}

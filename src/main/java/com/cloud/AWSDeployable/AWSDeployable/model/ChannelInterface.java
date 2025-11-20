package com.cloud.AWSDeployable.AWSDeployable.model;

public interface ChannelInterface {

    public void sendMessage(String from, String to, String subject, String body);
}

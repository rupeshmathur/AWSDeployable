package com.cloud.AWSDeployable.AWSDeployable.controller;

import com.cloud.AWSDeployable.AWSDeployable.model.UserDetailsDTO;
import com.cloud.AWSDeployable.AWSDeployable.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications/add")
public class UserDetailsController {

    public NotificationService notificationService;
    @Autowired
    public UserDetailsController(NotificationService notificationService)
    {
        this.notificationService = notificationService;
    }

    @PostMapping("/users/subscribedForNotifications")
    @CrossOrigin
    public String bulkSubscription(@RequestBody List<UserDetailsDTO> userDetails) {
        System.out.println("Received user details: " + userDetails);
        notificationService.subscribeUserToNotifications(userDetails);
        return "User details received successfully!";
    }

    @PostMapping("/user/subscribe")
    @CrossOrigin
    public String addUser(@RequestBody UserDetailsDTO userDetails) {
        System.out.println("Received user details: " + userDetails);
        notificationService.subscribeUserToNotifications(userDetails);
        return "User details received successfully!";
    }


}

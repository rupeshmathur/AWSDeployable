package com.cloud.AWSDeployable.AWSDeployable.service;

import com.cloud.AWSDeployable.AWSDeployable.entities.UserDetails;
import com.cloud.AWSDeployable.AWSDeployable.model.UserDetailsDTO;
import com.cloud.AWSDeployable.AWSDeployable.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {
    public UserDetailsRepository userDetailsRepository;

    @Autowired

    public NotificationService(UserDetailsRepository userDetailsRepository) {
        this.userDetailsRepository = userDetailsRepository;
    }

    public void subscribeUserToNotifications(List<UserDetailsDTO> userDetailsDTO) {
        List<UserDetails> users = userDetailsDTO.stream()
                .map(dto -> {
                    UserDetails entity = new UserDetails();
                    entity.setName(dto.getName());
                    entity.setEmail(dto.getEmail());
                    entity.setPhone(dto.getPhone());
                    entity.setPhoneSameAsWhatsapp(dto.isPhoneSameAsWhatsapp());
                    entity.setSubscribeNotifications(dto.isSubscribeNotifications());
                    entity.setWorkEmailProvided(dto.isWorkEmailProvided());
                    entity.setWorkEmail(dto.getWorkEmail());
                    entity.setNotificationFrequencies(dto.getNotificationFrequency());
                    return entity;
                })
                .collect(Collectors.toList());

        userDetailsRepository.saveAll(users);
    }

    public void subscribeUserToNotifications(UserDetailsDTO userDetailsDTO) {
        System.out.println("isPhoneSameAsWhatsapp : " + userDetailsDTO.isPhoneSameAsWhatsapp());
        System.out.println("subscribeNotifications : " + userDetailsDTO.isSubscribeNotifications());
        UserDetails entity = new UserDetails();
        entity.setName(userDetailsDTO.getName());
        entity.setEmail(userDetailsDTO.getEmail());
        entity.setPhone(userDetailsDTO.getPhone());
        entity.setPhoneSameAsWhatsapp(userDetailsDTO.isPhoneSameAsWhatsapp());
        entity.setSubscribeNotifications(userDetailsDTO.isSubscribeNotifications());
        entity.setWorkEmailProvided(userDetailsDTO.isWorkEmailProvided());
        entity.setWorkEmail(userDetailsDTO.getWorkEmail());
        entity.setNotificationFrequencies(userDetailsDTO.getNotificationFrequency());

        userDetailsRepository.save(entity);
    }

}

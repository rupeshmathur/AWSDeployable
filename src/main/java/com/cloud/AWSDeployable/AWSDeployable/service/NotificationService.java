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
                    entity.setWhatsapp(dto.isPhoneSameAsWhatsapp());
                    entity.setSubscribeNotifications(dto.isSubscribed());
                    entity.setWorkEmailProvided(dto.isWorkEmailProvided());
                    entity.setWorkEmail(dto.getWorkEmail());
                    entity.setNotificationFrequencies(dto.getNotificationFrequency());
                    return entity;
                })
                .collect(Collectors.toList());

        userDetailsRepository.saveAll(users);
    }

}

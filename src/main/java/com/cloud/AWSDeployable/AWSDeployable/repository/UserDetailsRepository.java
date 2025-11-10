package com.cloud.AWSDeployable.AWSDeployable.repository;

import com.cloud.AWSDeployable.AWSDeployable.entities.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends MongoRepository<UserDetails, String> {

    Optional<List<UserDetails>> findBySubscribeNotificationsTrueAndNotificationFrequenciesContains(String notificationFrequencies);

    // Convenience methods for each frequency
    default Optional<List<UserDetails>> isSubscribedForDaily() {
        System.out.println("Inside repo");
        return findBySubscribeNotificationsTrueAndNotificationFrequenciesContains("Daily");
    }

    default Optional<List<UserDetails>> isSubscribedForWeekly() {
        return findBySubscribeNotificationsTrueAndNotificationFrequenciesContains("Weekly");
    }

    default Optional<List<UserDetails>> isSubscribedForMonthly() {
        return findBySubscribeNotificationsTrueAndNotificationFrequenciesContains("Monthly");
    }

    default Optional<List<UserDetails>> isSubscribedForYearly() {
        return findBySubscribeNotificationsTrueAndNotificationFrequenciesContains("Yearly");
    }

}

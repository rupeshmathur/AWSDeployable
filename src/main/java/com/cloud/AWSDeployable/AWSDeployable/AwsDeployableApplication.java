package com.cloud.AWSDeployable.AWSDeployable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableMongoRepositories(basePackages = "com.cloud.AWSDeployable.AWSDeployable.repository")
@ComponentScan(basePackages = "com.cloud.AWSDeployable.AWSDeployable.*")
public class AwsDeployableApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsDeployableApplication.class, args);
	}

}

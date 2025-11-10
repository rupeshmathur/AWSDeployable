package com.cloud.AWSDeployable.AWSDeployable.config;

import com.fasterxml.jackson.databind.util.ClassUtil;
import jdk.jfr.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class InternalThreadPoolConfig {

    @Bean
    @Name("internalThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor internalThreadPoolTaskExecutor(){

        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(100);
        taskExecutor.setMaxPoolSize(100);
        taskExecutor.setQueueCapacity(100);
        return  taskExecutor;

    }
}

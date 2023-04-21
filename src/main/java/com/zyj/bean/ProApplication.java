package com.zyj.bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties
@EnableCaching
@EnableAsync
@EnableScheduling
public class ProApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProApplication.class, args);
    }
}

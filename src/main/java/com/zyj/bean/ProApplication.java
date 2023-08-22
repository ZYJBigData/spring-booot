package com.zyj.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Configuration
@EnableConfigurationProperties
@EnableCaching
@EnableAsync
@EnableScheduling
@Slf4j
public class ProApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ProApplication.class, args);
    }
}

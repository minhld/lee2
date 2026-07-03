package com.minh.lee2.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AppControl {
    @PostConstruct
    public void init() {
        log.info("All beans has been initialized");
    }

    @PreDestroy
    public void cleanup() {
        log.info("Clean before you go");
    }

}

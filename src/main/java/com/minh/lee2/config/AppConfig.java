package com.minh.lee2.config;

import com.minh.lee2.repository.CustomerOrderDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public CustomerOrderDao customerOrderData(@Qualifier("customerOrderDao") CustomerOrderDao customerOrderDao) {
        return customerOrderDao;
    }

}

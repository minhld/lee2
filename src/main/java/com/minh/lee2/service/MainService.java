package com.minh.lee2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.minh.lee2.model.CustomerOrder;
import com.minh.lee2.repository.CustomerOrderDao;
import jakarta.servlet.ServletContext;
import com.minh.lee2.model.SystemInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Service
public class MainService {
    private final ServletContext servletContext;

    @Autowired
    @Qualifier("customerOrderData")
    private CustomerOrderDao customerOrderDao1;

    @Autowired
    ObjectMapper objectMapper;

    public MainService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public SystemInfo getSystemInfo() {
        return new SystemInfo(
                System.getProperty("java.version"),
                servletContext.getServerInfo(),
                new SystemInfo.SystemDetails(
                        System.getProperty("os.version"),
                        System.getProperty("os.name"),
                        System.getProperty("os.arch")
                )
        );
    }

    public CustomerOrder getCustomerOrder(Long id) {
        CustomerOrder customerOrder = this.customerOrderDao1.getReferenceById(id);
        log.info("getCustomerOrder:{}", objectMapper.writeValueAsString(customerOrder));
        return customerOrder;
    }
}

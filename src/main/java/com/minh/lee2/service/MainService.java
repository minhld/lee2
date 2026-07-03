package com.minh.lee2.service;

import com.minh.lee2.config.AppProperties;
import com.minh.lee2.controller.model.CustomerInput;
import com.minh.lee2.exception.CustomerNotFoundException;
import com.minh.lee2.model.Customer;
import com.minh.lee2.model.CustomerOrder;
import com.minh.lee2.payment.PaymentInfo;
import com.minh.lee2.payment.PaymentService;
import com.minh.lee2.repository.CustomerDao;
import com.minh.lee2.repository.CustomerOrderDao;
import jakarta.persistence.EntityNotFoundException;
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
    private AppProperties appProperties;

    @Autowired
    @Qualifier("customerOrderData")
    private CustomerOrderDao customerOrderData;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    ObjectMapper objectMapper;

    public MainService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public SystemInfo getSystemInfo() {
        return new SystemInfo(
                System.getProperty("java.version"),
                servletContext.getServerInfo(),
                appProperties.getName(),
                new SystemInfo.SystemDetails(
                        System.getProperty("os.version"),
                        System.getProperty("os.name"),
                        System.getProperty("os.arch")
                )
        );
    }

    public CustomerOrder getCustomerOrder(Long id) {
        CustomerOrder customerOrder = this.customerOrderData.getReferenceById(id);
        log.info("getCustomerOrder:{}", objectMapper.writeValueAsString(customerOrder));

        log.info("Applying Payment");
        paymentService.pay(new PaymentInfo());

        return customerOrder;
    }

    public Customer getCustomer(Long id) {
        log.info("Get customer by ID: {}", id);
        try {
            Customer customer = this.customerDao.getReferenceById(id);
            log.info("Found customer: {}", customer.getFirstName());
            return customer;
        } catch (Throwable e) {
            log.info("Customer with ID {} not found", id);
            throw new CustomerNotFoundException(id);
        }
    }

    public Customer createCustomer(CustomerInput customer) {
        log.info("Create new customer from the input: {}", customer);
        Customer newCustomer = Customer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
        return this.customerDao.save(newCustomer);
    }
}

package com.minh.lee2.service;

import com.minh.lee2.controller.model.CustomerInput;
import com.minh.lee2.exception.CustomerNotFoundException;
import com.minh.lee2.model.Customer;
import com.minh.lee2.repository.CustomerDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Cacheable("customers")
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

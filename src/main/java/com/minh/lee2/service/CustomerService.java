package com.minh.lee2.service;

import com.minh.lee2.controller.model.CustomerInput;
import com.minh.lee2.exception.CustomerNotFoundException;
import com.minh.lee2.model.Customer;
import com.minh.lee2.repository.CustomerOrderDao;
import com.minh.lee2.repository.CustomerDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    @Qualifier("customerOrderDao")
    private CustomerOrderDao customerOrderDao;

    @Cacheable("customers")
    public Customer getCustomer(String firstName) {
        log.info("Get customer by first name: {}", firstName);
        Customer customer = customerDao.findByFirstName(firstName).stream()
                .findFirst()
                .orElseThrow(() -> {
                    log.info("Customer with first name {} not found", firstName);
                    return new CustomerNotFoundException(firstName);
                });
        customer.setOrders(customerOrderDao.findByCustomerId(customer.getId()));
        return customer;
    }

    public List<Customer> getAll() {
        return StreamSupport.stream(customerDao.findAll().spliterator(), false)
                .toList();
    }

    public Customer createCustomer(CustomerInput customer) {
        log.info("Create new customer from the input: {}", customer);
        Customer newCustomer = Customer.builder()
                .id(UUID.randomUUID().toString())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
        return this.customerDao.save(newCustomer);
    }
}

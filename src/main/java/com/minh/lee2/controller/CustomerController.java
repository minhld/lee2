package com.minh.lee2.controller;

import com.minh.lee2.controller.model.CustomerInput;
import com.minh.lee2.model.Customer;
import com.minh.lee2.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @PostMapping(path = "/customer/add")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody CustomerInput customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }

}

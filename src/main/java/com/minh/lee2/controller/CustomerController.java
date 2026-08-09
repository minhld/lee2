package com.minh.lee2.controller;

import com.minh.lee2.controller.model.CustomerInput;
import com.minh.lee2.model.Customer;
import com.minh.lee2.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Profile({ "dev","stage" })
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping(path = "/customer/{firstName}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String firstName) {
        return ResponseEntity.ok(customerService.getCustomer(firstName));
    }

    @GetMapping(path = "/customer/all")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return ResponseEntity.of(Optional.ofNullable(customerService.getAll()));
    }

    @PostMapping(path = "/customer/add")
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody CustomerInput customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }

}

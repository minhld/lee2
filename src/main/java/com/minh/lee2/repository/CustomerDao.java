package com.minh.lee2.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import com.minh.lee2.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerDao extends CosmosRepository<Customer, Long> {
    List<Customer> findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

}

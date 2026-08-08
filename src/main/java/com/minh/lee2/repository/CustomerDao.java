package com.minh.lee2.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.minh.lee2.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CosmosRepository<Customer, Long> {
}

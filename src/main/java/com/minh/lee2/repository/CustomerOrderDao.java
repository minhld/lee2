package com.minh.lee2.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.minh.lee2.model.CustomerOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderDao extends CosmosRepository<CustomerOrder, Long> {
}

package com.minh.lee2.repository;

import com.minh.lee2.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderDao extends JpaRepository<CustomerOrder, Long> {
}

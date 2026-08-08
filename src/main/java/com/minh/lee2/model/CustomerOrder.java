package com.minh.lee2.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Container(containerName = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrder {

    @Id
    private String id;

    @PartitionKey
    private String customerId;

    private String orderNumber;

    private LocalDate orderDate;

    private String status;

    private List<OrderItem> items = new ArrayList<>();
}

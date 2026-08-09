package com.minh.lee2.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Container(containerName = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    @Id
    private String id;

    private String sku;

    private String name;

    private BigDecimal unitPrice;

}

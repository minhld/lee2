package com.minh.lee2.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    private String itemId;

    private String sku;

    private String itemName;

    private Integer quantity;

    private BigDecimal unitPrice;
}

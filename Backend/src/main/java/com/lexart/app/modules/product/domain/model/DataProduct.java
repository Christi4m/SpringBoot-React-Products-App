package com.lexart.app.modules.product.domain.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DataProduct {

    private Long id;

    private BigDecimal price;

    private String color;
}

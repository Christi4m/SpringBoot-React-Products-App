package com.lexart.app.modules.product.adapter.in.web.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DataProductDTO {

    private Long id;

    private BigDecimal price;

    private String color;
}

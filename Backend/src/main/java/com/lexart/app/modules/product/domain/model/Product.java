package com.lexart.app.modules.product.domain.model;

import lombok.Data;

import java.util.List;

@Data
public class Product {

    private Long id;

    private String name;

    private String brand;

    private List<DataProduct> data;
}

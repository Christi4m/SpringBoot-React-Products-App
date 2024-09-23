package com.lexart.app.modules.product.adapter.in.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private String brand;
    private List<DataProductDTO> data;

}
package com.lexart.app.modules.product.adapter.out.persistence.mapper;

import com.lexart.app.modules.product.adapter.in.web.dto.DataProductDTO;
import com.lexart.app.modules.product.adapter.in.web.dto.ProductDTO;
import com.lexart.app.modules.product.domain.model.DataProduct;
import com.lexart.app.modules.product.domain.model.Product;

import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDTO mapToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setBrand(product.getBrand());
        productDTO.setData(product.getData().stream()
                .map(ProductMapper::mapDataToDTO)
                .collect(Collectors.toList()));
        return productDTO;
    }

    public static DataProductDTO mapDataToDTO(DataProduct dataProduct) {
        DataProductDTO dataProductDTO = new DataProductDTO();
        dataProductDTO.setId(dataProduct.getId());
        dataProductDTO.setPrice(dataProduct.getPrice());
        dataProductDTO.setColor(dataProduct.getColor());
        return dataProductDTO;
    }

    public static Product mapToDomain(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setData(productDTO.getData().stream()
                .map(ProductMapper::mapDataToDomain)
                .collect(Collectors.toList()));
        return product;
    }
    public static DataProduct mapDataToDomain(DataProductDTO dataProductDTO) {
        DataProduct dataProduct = new DataProduct();
        dataProduct.setId(dataProductDTO.getId());
        dataProduct.setPrice(dataProductDTO.getPrice());
        dataProduct.setColor(dataProductDTO.getColor());
        return dataProduct;
    }
}

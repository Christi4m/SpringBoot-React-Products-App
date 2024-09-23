package com.lexart.app.modules.product.adapter.out.persistence.repository;

import com.lexart.app.modules.product.adapter.out.persistence.entity.ProductEntity;
import com.lexart.app.modules.product.application.port.out.ProductRepository;
import com.lexart.app.modules.product.domain.model.DataProduct;
import com.lexart.app.modules.product.adapter.out.persistence.entity.DataProductEntity;
import com.lexart.app.modules.product.domain.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private final SpringProductRepository springProductRepository;

    public ProductRepositoryImpl(SpringProductRepository springProductRepository) {
        this.springProductRepository = springProductRepository;
    }

    @Override
    public void save(Product product) {
        ProductEntity entity = mapToEntity(product);
        springProductRepository.save(entity);
    }

    @Override
    public List<Product> getAll() {
        return springProductRepository.findAll()
                .stream()
                .map(this::mapToDomain)
                .collect(Collectors.toList());
    }

    private ProductEntity mapToEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setBrand(product.getBrand());
        entity.setData(product.getData().stream()
                .map(this::mapDataToEntity)
                .collect(Collectors.toList()));
        return entity;
    }

    private DataProductEntity mapDataToEntity(DataProduct dataProduct) {
        DataProductEntity entity = new DataProductEntity();
        entity.setId(dataProduct.getId());
        entity.setPrice(dataProduct.getPrice());
        entity.setColor(dataProduct.getColor());
        return entity;
    }

    private Product mapToDomain(ProductEntity entity) {
        Product product = new Product();
        product.setId(entity.getId());
        product.setName(entity.getName());
        product.setBrand(entity.getBrand());
        product.setData(entity.getData().stream()
                .map(this::mapDataToDomain)
                .collect(Collectors.toList()));
        return product;
    }

    private DataProduct mapDataToDomain(DataProductEntity entity) {
        DataProduct dataProduct = new DataProduct();
        dataProduct.setId(entity.getId());
        dataProduct.setPrice(entity.getPrice());
        dataProduct.setColor(entity.getColor());
        return dataProduct;
    }
}
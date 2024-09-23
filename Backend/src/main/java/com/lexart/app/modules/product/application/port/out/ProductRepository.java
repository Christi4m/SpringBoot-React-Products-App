package com.lexart.app.modules.product.application.port.out;

import com.lexart.app.modules.product.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product product);
    List<Product> getAll();
}
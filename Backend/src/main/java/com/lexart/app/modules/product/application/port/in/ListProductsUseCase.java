package com.lexart.app.modules.product.application.port.in;

import com.lexart.app.modules.product.domain.model.Product;

import java.util.List;

public interface ListProductsUseCase {
    List<Product> getAllProducts();
}
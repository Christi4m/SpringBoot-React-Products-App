package com.lexart.app.modules.product.application.port.in;

import com.lexart.app.modules.product.domain.model.Product;

public interface CreateProductUseCase {
    void createProduct(Product product);
}

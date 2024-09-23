package com.lexart.app.modules.product.application.service;


import com.lexart.app.modules.product.application.port.out.ProductRepository;
import com.lexart.app.modules.product.application.port.in.CreateProductUseCase;
import com.lexart.app.modules.product.application.port.in.ListProductsUseCase;
import com.lexart.app.modules.product.domain.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ListProductsUseCase, CreateProductUseCase {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }
}

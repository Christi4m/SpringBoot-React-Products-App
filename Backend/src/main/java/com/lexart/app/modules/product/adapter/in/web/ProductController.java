package com.lexart.app.modules.product.adapter.in.web;

import com.lexart.app.modules.product.adapter.in.web.dto.ProductDTO;
import com.lexart.app.modules.product.adapter.out.persistence.mapper.ProductMapper;
import com.lexart.app.modules.product.application.port.in.ListProductsUseCase;
import com.lexart.app.modules.product.application.port.in.CreateProductUseCase;
import com.lexart.app.modules.product.domain.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ListProductsUseCase listProductsUseCase;
    private final CreateProductUseCase createProductUseCase;

    public ProductController(ListProductsUseCase listProductUseCase, CreateProductUseCase createProductUseCase) {
        this.listProductsUseCase = listProductUseCase;
        this.createProductUseCase = createProductUseCase;
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDTO productDTO) {
        Product product = ProductMapper.mapToDomain(productDTO);
        createProductUseCase.createProduct(product);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        List<Product> products = listProductsUseCase.getAllProducts();
        return products.stream()
                .map(ProductMapper::mapToDTO)
                .collect(Collectors.toList());
    }


}

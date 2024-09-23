package com.lexart.app.modules.product.adapter.out.persistence.repository;

import com.lexart.app.modules.product.adapter.out.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringProductRepository extends JpaRepository<ProductEntity, Long> {
}

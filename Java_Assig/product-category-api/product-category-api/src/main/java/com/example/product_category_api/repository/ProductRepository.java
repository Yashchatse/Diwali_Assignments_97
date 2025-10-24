package com.example.product_category_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.product_category_api.model.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find products by price range
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

}
package com.example.product_category_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.product_category_api.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}

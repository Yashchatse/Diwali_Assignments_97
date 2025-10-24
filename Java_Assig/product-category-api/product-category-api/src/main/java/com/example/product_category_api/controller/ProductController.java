package com.example.product_category_api.controller;

import com.example.product_category_api.model.Category;
import com.example.product_category_api.model.Product;
import com.example.product_category_api.repository.CategoryRepository;
import com.example.product_category_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // a. Display all products with category
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // b. Insert new product
    @PostMapping
    public Product createProduct(@RequestBody Map<String, Object> payload) {
        String productName = (String) payload.get("name");
        BigDecimal price = new BigDecimal(payload.get("price").toString());
        String categoryName = (String) payload.get("categoryName");

        // Find or create category
        Category category = categoryRepository.findByName(categoryName);
        if (category == null) {
            category = categoryRepository.save(new Category(categoryName));
        }

        Product product = new Product(productName, price, category);
        return productRepository.save(product);
    }

    // c. Display products in price range
    @GetMapping("/price")
    public List<Product> getProductsByPriceRange(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        if (min.compareTo(max) > 0) {
            throw new IllegalArgumentException("Min price cannot be greater than max price");
        }
        return productRepository.findByPriceBetween(min, max);
    }

    // d. Update product price by ID
    @PutMapping("/{id}/price")
    public ResponseEntity<Product> updateProductPrice(
            @PathVariable Long id,
            @RequestBody Map<String, BigDecimal> payload) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        BigDecimal newPrice = payload.get("price");
        if (newPrice == null || newPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be non-negative");
        }

        product.setPrice(newPrice);
        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }
}
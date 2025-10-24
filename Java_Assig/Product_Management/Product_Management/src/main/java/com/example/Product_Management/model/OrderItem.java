package com.example.Product_Management.model;


import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class OrderItem {

    private Long productId;      
    private String productName;  
    private Integer quantity;
    private BigDecimal price;    

    // Constructors
    public OrderItem() {}

    public OrderItem(Long productId, String productName, Integer quantity, BigDecimal price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}

package com.example.Product_Management.model;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders1")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Long customerId; 

    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderItem> orderItems = new ArrayList<>();

    private BigDecimal totalAmount;

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // Constructors
    public Order() {}

    public Order(Long customerId, List<OrderItem> orderItems, BigDecimal totalAmount, OrderStatus status) {
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.totalAmount = totalAmount;
        this.orderDate = LocalDateTime.now();
        this.status = status;
    }

    // Getters and Setters
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public List<OrderItem> getOrderItems() { return orderItems; }
    public void setOrderItems(List<OrderItem> orderItems) { this.orderItems = orderItems; }

    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
}

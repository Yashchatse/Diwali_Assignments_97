package com.example.Product_Management.service;


import com.example.Product_Management.model.Order;
import com.example.Product_Management.model.OrderItem;
import com.example.Product_Management.model.OrderStatus;
import com.example.Product_Management.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Order order) {
        order.setOrderDate(java.time.LocalDateTime.now());
        if (order.getStatus() == null) {
            order.setStatus(OrderStatus.PENDING);
        }
        return orderRepository.save(order);
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public Order updateOrderStatus(Long orderId, OrderStatus newStatus) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(newStatus);
        return orderRepository.save(order);
    }

    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setStatus(OrderStatus.CANCELLED);
        orderRepository.save(order);
    }
}

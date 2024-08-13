package com.example.shopcamera.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    // Getters and Setters


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Order() {
    }

    public Order(Long orderId, User user, BigDecimal totalAmount, String status, Timestamp createdAt, List<OrderItem> orderItems) {
        this.orderId = orderId;
        this.user = user;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = createdAt;
        this.orderItems = orderItems;
    }
}


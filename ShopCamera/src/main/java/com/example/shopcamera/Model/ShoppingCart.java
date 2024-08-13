package com.example.shopcamera.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    // Getters and Setters


    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public ShoppingCart() {
    }

    public ShoppingCart(Long cartId, User user, Product product, int quantity, Timestamp createdAt) {
        this.cartId = cartId;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.createdAt = createdAt;
    }
}

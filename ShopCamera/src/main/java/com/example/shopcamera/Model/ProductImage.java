package com.example.shopcamera.Model;



import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "product_images")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    // Getters and Setters

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public ProductImage() {
    }

    public ProductImage(Long imageId, Product product, String imageUrl, Timestamp createdAt) {
        this.imageId = imageId;
        this.product = product;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
    }
}

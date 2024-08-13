package com.example.shopcamera.Controller;



import com.example.shopcamera.Model.Product;
import com.example.shopcamera.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId) {
        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
                                                 @RequestBody Product productDetails) {
        Product updatedProduct = productService.updateProduct(productId, productDetails);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}


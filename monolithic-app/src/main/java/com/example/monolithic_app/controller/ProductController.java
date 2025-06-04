package com.example.monolithic_app.controller;

import com.example.monolithic_app.model.product;
import com.example.monolithic_app.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private productService productService;

    @GetMapping
    public List<product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public product createProduct(@RequestBody product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public product updateProduct(@PathVariable Long id, @RequestBody product productDetails) {
        return productService.updateProduct(id, productDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
}

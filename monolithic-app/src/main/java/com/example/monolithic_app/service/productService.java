package com.example.monolithic_app.service;

import com.example.monolithic_app.model.product;
import com.example.monolithic_app.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productService {

    @Autowired
    private productRepository productRepository;

    public List<product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public product createProduct(product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public product updateProduct(Long id, product productDetails) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDetails.getName());
            product.setPrice(productDetails.getPrice());
            return productRepository.save(product);
        }).orElse(null);
    }
}

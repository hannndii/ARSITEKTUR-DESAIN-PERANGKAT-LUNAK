package com.example.monolithic_app.repository;

import com.example.monolithic_app.model.product;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;
@Repository

public interface productRepository extends JpaRepository<product, Long> {

}


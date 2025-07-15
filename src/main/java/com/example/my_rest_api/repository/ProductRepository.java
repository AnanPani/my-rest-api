package com.example.my_rest_api.repository;

import com.example.my_rest_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Marks this as a Spring Data JPA repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // No additional methods are needed; JpaRepository provides basic CRUD
    // operations
    // You can define custom query methods here if needed
}
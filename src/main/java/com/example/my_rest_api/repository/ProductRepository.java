package com.example.my_rest_api.repository;

import com.example.my_rest_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
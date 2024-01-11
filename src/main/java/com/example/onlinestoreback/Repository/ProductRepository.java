package com.example.onlinestoreback.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onlinestoreback.Entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
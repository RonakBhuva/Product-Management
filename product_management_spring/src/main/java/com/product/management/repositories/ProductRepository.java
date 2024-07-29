package com.product.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.management.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}

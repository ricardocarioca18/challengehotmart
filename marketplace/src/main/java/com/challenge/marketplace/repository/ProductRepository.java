package com.challenge.marketplace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.marketplace.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
}

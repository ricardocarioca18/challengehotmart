package com.challenge.marketplace.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.marketplace.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Page<Product> findByName(Pageable pageable, String name);
	
	Page<Product> findByCategoryName(Pageable pageable, String name);
	
	Page<Product> findByNameAndCategoryNameOrderByScore(Pageable pageable, String name, String nameCategory);
}

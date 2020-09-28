package com.challenge.marketplace.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import com.challenge.marketplace.model.Product;
import com.challenge.marketplace.model.ProductCategory;

public class ProductDto {

	private Long id;
	private String name;
	private String description;
	private LocalDateTime creationDate;
	private ProductCategory category;
	private float score;
		
	
	public ProductDto(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.creationDate = product.getCreationDate();
		this.category = product.getProductCategory();
		this.score = product.getScore();
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}	
	public ProductCategory getProductCategory() {
		return category;
	}
	public float getScore() {
		return score;
	}

	public static Page<ProductDto> convert(Page<Product> products){
		return products.map(ProductDto::new);
	}	
	
}

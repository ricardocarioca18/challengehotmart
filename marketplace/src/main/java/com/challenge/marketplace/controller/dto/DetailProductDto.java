package com.challenge.marketplace.controller.dto;

import java.time.LocalDateTime;

import com.challenge.marketplace.model.Product;
import com.challenge.marketplace.model.ProductCategory;

public class DetailProductDto {

	private Long id;
	private String name;
	private String description;
	private LocalDateTime creationDate;
	private ProductCategory category;
	private float score;
	
	public DetailProductDto(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.creationDate = product.getCreationDate();
		this.score = product.getScore();
		this.category = product.getProductCategory();
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
	
	
	
	
}

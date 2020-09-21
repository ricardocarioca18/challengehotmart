package com.challenge.marketplace.controller.dto;

import java.time.LocalDateTime;

import com.challenge.marketplace.model.Product;

public class DetailProductDto {

	private Long id;
	private String name;
	private String description;
	private LocalDateTime creationDate;
	
	public DetailProductDto(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.creationDate = product.getCreationDate();
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
	
	
	
	
}

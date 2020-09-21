package com.challenge.marketplace.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.challenge.marketplace.model.Product;

public class ProductDto {

	private Long id;
	private String name;
	private String description;
	private LocalDateTime creationDate;
		
	
	public ProductDto(Product product) {
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
	
	public static List<ProductDto> convert(List<Product> products){
		return products.stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	
}

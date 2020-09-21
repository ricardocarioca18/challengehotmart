package com.challenge.marketplace.controller.form;


import com.challenge.marketplace.model.Product;
import com.challenge.marketplace.repository.ProductRepository;

public class UpdateProductForm {

	private String name;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Product update(Long id, ProductRepository productRepository) {
		Product product = productRepository.getOne(id);
		product.setName(name);
		product.setDescription(description);
		
		return product;
	}
	
	
	
	
}

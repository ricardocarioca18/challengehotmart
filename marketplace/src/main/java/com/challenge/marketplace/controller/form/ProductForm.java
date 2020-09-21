package com.challenge.marketplace.controller.form;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.challenge.marketplace.model.Product;
import com.challenge.marketplace.repository.ProductRepository;

public class ProductForm {
	
	@NotNull @NotEmpty @Length(min = 5)
	private String name;
	@NotNull @NotEmpty @Length(min = 10)
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
	
	public Product convert(ProductRepository productRepository) {
		return new Product(name, description);
	}

}

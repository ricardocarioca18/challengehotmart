package com.challenge.marketplace.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.marketplace.controller.form.UpdateProductForm;
import com.challenge.marketplace.model.Product;
import com.challenge.marketplace.repository.ProductRepository;

import javassist.NotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public Product find(Long id) throws NotFoundException {
		Optional<Product> productOptional = productRepository.findById(id);
		return productOptional.orElseThrow(() -> new NotFoundException("Product not found"));		
	}

	public Product update(Long id, @Valid UpdateProductForm form) throws NotFoundException {		
		Product product = find(id);
		product.update(form);
		productRepository.save(product);
		return product;		
	}
	
}

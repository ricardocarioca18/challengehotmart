package com.challenge.marketplace.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.challenge.marketplace.controller.dto.DetailProductDto;
import com.challenge.marketplace.controller.dto.ProductDto;
import com.challenge.marketplace.controller.form.ProductForm;
import com.challenge.marketplace.controller.form.UpdateProductForm;
import com.challenge.marketplace.model.Product;
import com.challenge.marketplace.repository.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<ProductDto> list(){
		List<Product> products = productRepository.findAll();
		return ProductDto.convert(products);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ProductDto> insert(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder){
		Product product = form.convert(productRepository);
		productRepository.save(product);
		
		URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDto(product));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetailProductDto> find(@PathVariable Long id){
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return ResponseEntity.ok(new DetailProductDto(product.get()));
		}
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody @Valid UpdateProductForm form){		
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product product = form.update(id, productRepository);
			return ResponseEntity.ok(new ProductDto(product));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}

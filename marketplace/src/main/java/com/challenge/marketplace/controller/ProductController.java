package com.challenge.marketplace.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
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
	@Cacheable(value = "productsList")
	public Page<ProductDto> list(@PageableDefault(sort ="id", direction = Direction.ASC, page = 0, size = 5) Pageable pageable){
		Page<Product> products = productRepository.findAll(pageable);
		return ProductDto.convert(products);
	}
	
	@PostMapping
	@Transactional
	@CacheEvict(value = "productsList", allEntries = true)
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
	
	
	
	@GetMapping("/searchCategory/{name}&{category}")
	public Page<ProductDto> searchByNameAndCategory(@PageableDefault(sort ="id", direction = Direction.ASC, page = 0, size = 5) Pageable pageable, @PathVariable String name, @PathVariable String category){
		Page<Product> products = productRepository.findByNameAndCategoryNameOrderByScore(pageable, name, category);
		System.out.println("Produtos: "+products);
		return ProductDto.convert(products);
		
	}
	
	
	@DeleteMapping("/{id}")
	@CacheEvict(value = "productsList", allEntries = true)
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			productRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}

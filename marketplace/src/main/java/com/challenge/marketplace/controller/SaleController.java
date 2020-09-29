package com.challenge.marketplace.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.marketplace.controller.dto.DetailSaletDto;
import com.challenge.marketplace.model.Sale;
import com.challenge.marketplace.repository.SaleRepository;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@GetMapping("/searchSales/{id}")
	public ResponseEntity<DetailSaletDto> searchById(@PathVariable Long id){
		
		Optional<Sale> sales = saleRepository.findById(id);
		if(sales.isPresent()) {
			return ResponseEntity.ok(new DetailSaletDto(sales.get()));
		}
		return ResponseEntity.notFound().build();		
		
	}	
	
}

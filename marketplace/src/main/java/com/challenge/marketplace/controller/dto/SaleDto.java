package com.challenge.marketplace.controller.dto;

import java.time.LocalDate;

import org.springframework.data.domain.Page;

import com.challenge.marketplace.model.Buyer;
import com.challenge.marketplace.model.Product;
import com.challenge.marketplace.model.Sale;
import com.challenge.marketplace.model.Seller;

public class SaleDto {

	private Long id;
	private Seller seller;
	private Buyer buyer;
	private Product product;
	private int evaluation;
	private LocalDate date;
	
	
	
	public SaleDto(Sale sale) {
		this.id = sale.getId();
		this.seller = sale.getSeller();
		this.buyer = sale.getBuyer();
		this.product = sale.getProduct();
		this.evaluation = sale.getEvaluation();
		this.date = sale.getDate();
	}
	public Long getId() {
		return id;
	}
	public Seller getSeller() {
		return seller;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public Product getProduct() {
		return product;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public LocalDate getDate() {
		return date;
	}
	
	public static Page<SaleDto> convert(Page<Sale> sales){
		return sales.map(SaleDto::new);
	}
	
}

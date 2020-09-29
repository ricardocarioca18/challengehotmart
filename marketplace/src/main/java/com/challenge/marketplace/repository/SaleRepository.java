package com.challenge.marketplace.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.challenge.marketplace.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
}

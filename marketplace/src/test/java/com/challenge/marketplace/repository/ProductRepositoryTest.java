package com.challenge.marketplace.repository;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.junit4.SpringRunner;

import com.challenge.marketplace.model.Product;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void testProductByName() {
		String nameProduct = "Carro";
		Product product = productRepository.findByName(nameProduct);
		Assert.assertNotNull(product);
		Assert.assertEquals(nameProduct, product.getName());
	}

}

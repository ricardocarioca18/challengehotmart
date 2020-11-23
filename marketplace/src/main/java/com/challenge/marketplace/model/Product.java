package com.challenge.marketplace.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

import com.challenge.marketplace.controller.form.UpdateProductForm;

//import org.hibernate.envers.Audited;


@Entity
//@Audited
public class Product {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private LocalDateTime creationDate = LocalDateTime.now();
	@ManyToOne
	private ProductCategory category;
	private float score;
	
	public Product() {		
	}
	
	public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public ProductCategory getProductCategory() {
		return category;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.category = productCategory;
	}

	public void update(@Valid UpdateProductForm form) {
		this.name = form.getName();
		this.description = form.getDescription();
		
	}
	
	
	
	
}

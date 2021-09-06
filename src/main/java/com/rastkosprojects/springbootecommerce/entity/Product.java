/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author rastko
 */
@Entity
@Table(name = "product")
//@Data//lombok automatically generates getters and setters
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private ProductCategory category;
    
    @Column(name = "sku")
    private String sku;//bar-code
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "active")
    private boolean active;
    
    @Column(name = "units_in_stock")
    private int unitsInStock;
    
    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;
    
    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date dateUpdated;

	public Long getId() {
		return id;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		if(category == null) {
			throw new NullPointerException("Product category cannot be null");
		}
		this.category = category;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		if(sku == null) {
			throw new NullPointerException("Sku cannot be null");
		}
		if(sku.length() < 2) {
			throw new RuntimeException("Sku length must be greater than 2");
		}
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null) {
			throw new NullPointerException("Name cannot be null");
		}
		if(name.length() < 2) {
			throw new RuntimeException("Name length must be greater than 2");
		}
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if(description == null) {
			throw new NullPointerException("Description cannot be null");
		}
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		if(unitPrice == null) {
			throw new NullPointerException("Unit price cannot be null");
		}
		if(unitPrice.compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("Unit price must be greater than zero!");
		}
		this.unitPrice = unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		if(unitsInStock < 0) {
			throw new RuntimeException("Units in stock must be greater than or equal to zero!");
		}
		
		this.unitsInStock = unitsInStock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
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
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}

}

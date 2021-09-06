/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author rastko
 */

@Entity
@Table(name="order_item")

public class OrderItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "product_id")
    private Long productId;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

	public Long getId() {
		return id;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity <= 0) {
			throw new RuntimeException("Quantity must be greater than zero!");
		}
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		if(productId == null) {
			throw new NullPointerException("Product id cannot be null");
		}
		this.productId = productId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if(order == null) {
			throw new NullPointerException("Order cannot be null!");
		}
		this.order = order;
	}
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.dto;

import com.rastkosprojects.springbootecommerce.entity.Address;
import com.rastkosprojects.springbootecommerce.entity.Customer;
import com.rastkosprojects.springbootecommerce.entity.Order;
import com.rastkosprojects.springbootecommerce.entity.OrderItem;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author rastko
 */

public class Purchase {
    
    private Customer customer;
    
    private Address shippingAddress;
    
    private Address billingAddress;
    
    private Order order;
    
    private Set<OrderItem> orderItems;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		if(customer == null) {
			throw new NullPointerException("Customer cannot be null");
		}
		this.customer = customer;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		if(shippingAddress == null) {
			throw new NullPointerException("Shipping address cannot be null");
		}
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		if(billingAddress == null) {
			throw new NullPointerException("Billing address cannot be null");
		}
		this.billingAddress = billingAddress;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		if(order == null) {
			throw new NullPointerException("Order cannot be null");
		}
		this.order = order;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		if(orderItems == null) {
			throw new NullPointerException("Order items cannot be null");
		}
		if(orderItems.isEmpty()) {
			throw new RuntimeException("Order items cannot be empty.");
		}
		this.orderItems = orderItems;
	}
}

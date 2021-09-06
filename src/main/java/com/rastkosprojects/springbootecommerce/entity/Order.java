/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 *
 * @author rastko
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "total_quantity")
    private int totalQuantity;
    
    @Column(name = "total_price")
    private BigDecimal totalPrice;
    
    @Column(name = "status")
    private String status;
    
    @CreationTimestamp
    @Column(name = "date_created")
    private Date dateCreated;
    
    @UpdateTimestamp
    @Column(name = "last_updated")
    private Date lastUpdated;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="order")
    private Set<OrderItem> orderItems = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(name ="customer_id")
    private Customer customer;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id")
    private Address shippingAddress;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id")
    private Address billingAddress;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		if(orderTrackingNumber == null) {
			throw new NullPointerException("Order tracking number cannot be null.");
		}
		if(orderTrackingNumber.length() != 36) {
			throw new RuntimeException("Order tracking number must be a 36 character UUID");
		}
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		if(totalQuantity == 0) {
			throw new RuntimeException("Total quantity cannot be zero.");
		}
		this.totalQuantity = totalQuantity;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		if(totalPrice.equals(BigDecimal.ZERO)) {
			throw new RuntimeException("Total price cannot be zero");
		}
		this.totalPrice = totalPrice;
	}

	

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		if(orderItems == null) {
			throw new NullPointerException("Order items cannot be null");
		}
		if(orderItems.isEmpty()) {
			throw new RuntimeException("Order items cannot be empty");
		}
		this.orderItems = orderItems;
	}

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

	public void add(OrderItem item){
        if(item != null){
            if(orderItems == null){
                orderItems = new HashSet<>();
            }
            orderItems.add(item);
            item.setOrder(this);
        }else {
        	throw new NullPointerException("Null items cannot be added to order!");
        }
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderTrackingNumber == null) ? 0 : orderTrackingNumber.hashCode());
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
		Order other = (Order) obj;
		if (orderTrackingNumber == null) {
			if (other.orderTrackingNumber != null)
				return false;
		} else if (!orderTrackingNumber.equals(other.orderTrackingNumber))
			return false;
		return true;
	}
    
}

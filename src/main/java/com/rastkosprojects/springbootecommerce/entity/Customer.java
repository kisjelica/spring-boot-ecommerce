/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.entity;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author rastko
 */
@Entity
@Table(name = "customer")

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Order> orders = new HashSet<>();
    
    public void add(Order order){
         if(order != null){
            if(orders == null){
                orders = new HashSet<>();
            }
            orders.add(order);
            order.setCustomer(this);
        }
    }

	public Long getId() {
		return id;
	}


	public String getFirstName() {
		
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName == null) {
			throw new NullPointerException("Cannot be null!");
		}
		if(firstName.length() < 2) {
			throw new RuntimeException("Name length must be at least 2.");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName == null) {
			throw new NullPointerException("Cannot be null!");
		}
		if(lastName.length() < 2) {
			throw new RuntimeException("Name length must be at least 2.");
		}
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if(email == null) {
			throw new NullPointerException("Cannot be null!");
		}
		
		if(!Pattern.matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", email)) {
			throw new RuntimeException("Invalid email address!");
		}
		this.email = email;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		if(orders == null) {
			throw new NullPointerException("Orders cannot be null.");
		}
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
    
}

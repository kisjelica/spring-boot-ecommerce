/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.dto;

import lombok.Data;

/**
 *
 * @author rastko
 */
//used to send java object as json
//@Data
public class PurchaseResponse {
    //lombok will only generate constructors for final fields
    //or add @NonNull
    private final String orderTrackingNumber;
    
    public PurchaseResponse(String orderTrackingNumber) {
    	if(orderTrackingNumber == null) {
			throw new NullPointerException("Order tracking number cannot be null.");
		}
		if(orderTrackingNumber.length() != 36) {
			throw new RuntimeException("Order tracking number must be a 36 character UUID");
		}
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.service;

import com.rastkosprojects.springbootecommerce.dto.Purchase;
import com.rastkosprojects.springbootecommerce.dto.PurchaseResponse;

/**
 *
 * @author rastko
 */
public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}

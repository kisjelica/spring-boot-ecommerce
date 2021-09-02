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
@Data
public class Purchase {
    
    private Customer customer;
    
    private Address shippingAddress;
    
    private Address billingAddress;
    
    private Order order;
    
    private Set<OrderItem> orderItems;
}

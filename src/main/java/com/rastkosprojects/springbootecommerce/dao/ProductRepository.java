/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.dao;

import com.rastkosprojects.springbootecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rastko
 */
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
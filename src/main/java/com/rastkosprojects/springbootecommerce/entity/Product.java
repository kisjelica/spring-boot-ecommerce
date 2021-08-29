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
@Data//lombok automatically generates getters and setters
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private ProductCategory productCategory;
    
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
    
    @Column(name = "date_updated")
    @UpdateTimestamp
    private Date dateUpdated;

}

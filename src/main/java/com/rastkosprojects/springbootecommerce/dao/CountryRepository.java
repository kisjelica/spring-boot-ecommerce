/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.dao;

import com.rastkosprojects.springbootecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author rastko
 */
@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "countries", path="countries")
public interface CountryRepository extends JpaRepository<Country, Integer>{
    
}
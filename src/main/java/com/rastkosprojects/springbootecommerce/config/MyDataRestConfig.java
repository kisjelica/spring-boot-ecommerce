/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.config;

import com.rastkosprojects.springbootecommerce.entity.Product;
import com.rastkosprojects.springbootecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 *
 * @author rastko
 */
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
        //disable HTTP methods PUT, POST and DELETE for the Product entity
        config.getExposureConfiguration().forDomainType(Product.class)
        .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
        
        //the same for ProductCategory
        config.getExposureConfiguration().forDomainType(ProductCategory.class)
        .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
        
    }

}
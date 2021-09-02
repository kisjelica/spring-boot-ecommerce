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
@Data
public class PurchaseResponse {
    //lombok will only generate constructors for final fields
    //or add @NonNull
    private final String orderTrackingNumber;
}

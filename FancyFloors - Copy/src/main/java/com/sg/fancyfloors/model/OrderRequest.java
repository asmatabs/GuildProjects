/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.model;

import java.math.BigDecimal;

/**
 *
 * @author asmat
 */
public class OrderRequest {
    
        String customerName;
        String productType;
        String state;
        BigDecimal area;

    public String getCustomerName() {
        return customerName;
    }

    public String getProductType() {
        return productType;
    }

    public String getState() {
        return state;
    }

    public BigDecimal getArea() {
        return area;
    }

    public OrderRequest(String customerName, String productType, String state, BigDecimal area) {
        this.customerName = customerName;
        this.productType = productType;
        this.state = state;
        this.area = area;
    }
        
}

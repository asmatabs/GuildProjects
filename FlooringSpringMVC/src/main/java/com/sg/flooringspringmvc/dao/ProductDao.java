/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringspringmvc.dao;

import com.sg.flooringspringmvc.model.Product;

/**
 *
 * @author asmat
 */
public interface ProductDao {
 
    void initialize() throws FilePersistenceException;
    Product getProductByType(String productType);
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.dao;

import com.sg.fancyfloors.model.Product;
import com.sg.fancyfloors.model.Tax;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asmat
 */
public class ProductDaoFileImpl extends FileLoader implements ProductDao {

    public List<Product> prodList = new ArrayList<>();
    public static final String PRODUCT_FILE = "Products.csv";
    public static final String DELIMITER = ",";
    public static final int NO_OF_TOKENS = 3;
    public static final int PRODUCT_TYPE = 0;
    public static final int COST_PER_SQ_FOOT = 1;
    public static final int LABOR_COST_PER_SQ_FOOT = 2;

    public ProductDaoFileImpl() {
        try {
            initialize();
        } catch (FilePersistenceException ex) {
            Logger.getLogger(ProductDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void initialize() throws FilePersistenceException {
        FileReaderHandle(PRODUCT_FILE);
        String[] products;
        while ((products = FileReader(DELIMITER, NO_OF_TOKENS)) != null) {

            BigDecimal costPerSqFoot = new BigDecimal(products[COST_PER_SQ_FOOT]);
            BigDecimal laborCostPerSqFoot = new BigDecimal(products[LABOR_COST_PER_SQ_FOOT]);
            prodList.add(new Product(products[PRODUCT_TYPE], costPerSqFoot, laborCostPerSqFoot));
        }
        FileReaderClose();
    }
    
    @Override
    public Product getProductByType(String productType)
    {
        return prodList.stream()
                .filter((p) -> (p.getProductType() == null ? productType == null : p.getProductType().equals(productType)))
                .findAny()
                .orElse(null);
    }

}

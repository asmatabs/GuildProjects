/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.dao;

import com.sg.fancyfloors.model.Tax;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asmat
 */
public class TaxDaoFileImpl extends FileLoader implements TaxDao {

    public Map<String, BigDecimal> taxMap = new HashMap<>();
    public static final String TAX_FILE = "Taxes.csv";
    public static final String DELIMITER = ",";
    public static final int NO_OF_TOKENS = 2;
    public static final int STATE = 0;
    public static final int TAX_RATE = 1;

    public TaxDaoFileImpl() {
        try {
            initialize();
        } catch (FilePersistenceException ex) {
            Logger.getLogger(TaxDaoFileImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void initialize() throws FilePersistenceException {
        FileReaderHandle(TAX_FILE);
        String[] taxes;
        while ((taxes = FileReader(DELIMITER, NO_OF_TOKENS)) != null) {

            BigDecimal taxRate = new BigDecimal(taxes[TAX_RATE]);
           taxMap.put(taxes[STATE], taxRate);
        }
        FileReaderClose();
    }

    @Override
    public Tax getTaxByState(String state) {
        return (this.taxMap.get(state) != null ? (new Tax(state, this.taxMap.get(state))) : null);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.ui;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author asmat
 */
public interface UserIO {

    void print(String message);

    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);
    
    BigDecimal readBigDecimal(String prompt);

    String readString(String prompt);

    LocalDate readDate(String orderDate);

    public String readYorN(String do_you_wish_to_proceed_YN_);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.hello;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asmat
 */
public class Main {
    
    public static void main(String[] args) {
        
        List<BigDecimal> myDecimals = new ArrayList<>();
        myDecimals.add(BigDecimal.ONE);
        myDecimals.add(BigDecimal.valueOf(100.00));
        List<Long> myLongs = new ArrayList();
        myDecimals.forEach((item) -> {
            myLongs.add(Long.parseLong(item.toString()));
        });
        
        System.out.println(myLongs.toString());
    }
}

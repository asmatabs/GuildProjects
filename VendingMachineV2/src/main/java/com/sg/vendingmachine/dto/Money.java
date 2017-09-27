/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dto;

import java.math.BigDecimal;

/**
 *
 * @author asmat
 */
public class Money {
    
    public static final double QUART_IN_DOLLAR = 0.25;
    public static final double DIME_IN_DOLLAR = 0.10;
    public static final double NICK_IN_DOLLAR = 0.05;
    public static final double PENN_IN_DOLLAR = 0.01;
    
    private BigDecimal dollar = BigDecimal.ZERO;
    private BigDecimal quarter = BigDecimal.ZERO;
    private BigDecimal dime = BigDecimal.ZERO;
    private BigDecimal nickel = BigDecimal.ZERO;
    private BigDecimal penny = BigDecimal.ZERO;
    private BigDecimal totalAmount = BigDecimal.ZERO;


    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Money(BigDecimal dollar, BigDecimal quarter, BigDecimal dime, BigDecimal nickel, BigDecimal penny) {
        this.dollar = dollar;
        this.quarter = quarter;
        this.dime = dime;
        this.nickel = nickel;
        this.penny = penny;
        
        BigDecimal totalAmount = dollar.add((quarter.multiply(BigDecimal.valueOf(QUART_IN_DOLLAR)))
                                      .add((dime.multiply(BigDecimal.valueOf(DIME_IN_DOLLAR)))
                                        .add(nickel.multiply(BigDecimal.valueOf(NICK_IN_DOLLAR)))
                                        .add((penny.multiply(BigDecimal.valueOf(PENN_IN_DOLLAR))))));
        
        this.setTotalAmount(totalAmount);
        
    }

    /**
     * @return the dollar
     */
    public BigDecimal getDollar() {
        return dollar;
    }

    /**
     * @return the quarter
     */
    public BigDecimal getQuarter() {
        return quarter;
    }

    /**
     * @return the dime
     */
    public BigDecimal getDime() {
        return dime;
    }

    /**
     * @return the nickel
     */
    public BigDecimal getNickel() {
        return nickel;
    }

    /**
     * @return the penny
     */
    public BigDecimal getPenny() {
        return penny;
    }

    @Override
    public String toString() {
        return " Money {" + "dollar= " + dollar + ", quarter= " + quarter + ", dime= " + dime + ", nickel= " + nickel + ", penny= " + penny + ", total= " + totalAmount.toString() + " }";
    }
    
    
}

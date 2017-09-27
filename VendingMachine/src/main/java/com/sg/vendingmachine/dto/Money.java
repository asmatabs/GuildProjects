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
    private BigDecimal dollar;
    private BigDecimal quarter;
    private BigDecimal dime;
    private BigDecimal nickel;
    private BigDecimal penny;
    private BigDecimal totalAmount;
    private BigDecimal changeDue;

    public BigDecimal getChangeDue() {
        return changeDue;
    }

    public void setChangeDue(BigDecimal changeDue) {
        this.changeDue = changeDue;
    }

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
}

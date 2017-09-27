/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author asmat
 */
public class Order {

    int orderNumber;
    LocalDate orderDate;
    String customerName;
    Tax tax;
    Product product;
    BigDecimal area;
    BigDecimal materialCost;
    BigDecimal laborCost;
    BigDecimal taxAmt;
    BigDecimal total;
    
    public Order(int orderNumber, LocalDate orderDate) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTaxAmount() {
        return taxAmt;
    }

    public void setTaxAmount(BigDecimal taxes) {
        this.taxAmt = taxes;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.orderNumber);
        hash = 61 * hash + Objects.hashCode(this.customerName);
        hash = 61 * hash + Objects.hashCode(this.orderDate);
        hash = 61 * hash + Objects.hashCode(this.tax);
        hash = 61 * hash + Objects.hashCode(this.product);
        hash = 61 * hash + Objects.hashCode(this.area);
        hash = 61 * hash + Objects.hashCode(this.materialCost);
        hash = 61 * hash + Objects.hashCode(this.laborCost);
        hash = 61 * hash + Objects.hashCode(this.taxAmt);
        hash = 61 * hash + Objects.hashCode(this.total);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.orderNumber, other.orderNumber)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.taxAmt, other.taxAmt)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Order{" + "orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", customerName=" + customerName + ", tax=" + tax + ", product=" + product + ", area=" + area + ", materialCost=" + materialCost + ", laborCost=" + laborCost + ", taxAmt=" + taxAmt + ", total=" + total + '}';
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.service;

import com.sg.fancyfloors.dao.OrderDao;
import com.sg.fancyfloors.dao.ProductDao;
import com.sg.fancyfloors.dao.TaxDao;
import com.sg.fancyfloors.model.Order;
import com.sg.fancyfloors.model.OrderRequest;
import com.sg.fancyfloors.model.OrderResponse;
import com.sg.fancyfloors.model.Product;
import com.sg.fancyfloors.model.Tax;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author asmat
 */
public class FlooringOrders {

    OrderDao orderDao;
    ProductDao productDao;
    TaxDao taxDao;

    public FlooringOrders(OrderDao orderDao, ProductDao productDao, TaxDao taxDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.taxDao = taxDao;
    }

    public OrderResponse processOrder(OrderRequest orderRequest) {

        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderPlaced(false);
        boolean validRequest = true;

        //Validate ProductType
        Product currentProduct = productDao.getProductByType(orderRequest.getProductType());
        if (currentProduct == null) {
            orderResponse.setMessage("There is no such Product. Please check the Product Type");
            validRequest = false;
        }

        //Validate State
        Tax currentTax = taxDao.getTaxByState(orderRequest.getState());
        if (currentTax == null) {
            orderResponse.setMessage("Incorrect state.");
            validRequest = false;
        }

        if (orderRequest.getArea().intValue() <= 0) {
            orderResponse.setMessage("We need some Area to work with.");
            validRequest = false;
        }

        if (validRequest) {
            //Create new Order
            Order newOrder = new Order(orderDao.getNextOrderNumber(), LocalDate.now());
            newOrder.setCustomerName(orderRequest.getCustomerName());
            newOrder.setArea(orderRequest.getArea());
            newOrder.setProduct(currentProduct);
            newOrder.setTax(currentTax);
            
            updateCostForOrder(newOrder);
            
            
            orderResponse.setOrder(newOrder);
        }
        
        orderResponse.setOrderPlaced(true);
        return orderResponse;
    }
    
    private void updateCostForOrder(Order order)
    {
        //TODO: Rounding Tax and total to 2 digit ?
        
        //Material cost Area * Order.product.costPerSqFeet
        BigDecimal materialCost = order.getArea().multiply(order.getProduct().getCostPerSquareFoot());
        order.setMaterialCost(materialCost);
        
        //Labor cost area * order.product.laborcostpersqfeet
        BigDecimal laborCost = order.getArea().multiply(order.getProduct().getLaborCostPerSquareFoot());
        order.setLaborCost(laborCost);
        
        BigDecimal totalCost = materialCost.add(laborCost);
        
        BigDecimal tax = (totalCost.multiply(order.getTax().getTaxRate())).divide(BigDecimal.valueOf(100.00));
        order.setTaxAmount(tax);
        
        BigDecimal total = totalCost.add(tax);
        order.setTotal(total);
    }
}

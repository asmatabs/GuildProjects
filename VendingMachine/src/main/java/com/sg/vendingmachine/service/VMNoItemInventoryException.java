/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.service;

/**
 *
 * @author asmat
 */
public class VMNoItemInventoryException extends Exception {

    public VMNoItemInventoryException(String message) {
        super(message);
    }

    public VMNoItemInventoryException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

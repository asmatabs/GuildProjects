/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fiveobjects;

/**
 *
 * @author asmat
 */
public class Restaurant {
    
    String name;
    Waiter[] waiter;
    Cashier[] cashier;
    Menu menu;
    boolean driveThrough;
    
    Tables[] tables;
    boolean orderAndPickUp;
    
    int hoursOfOperation;
    
    DateTime openTime;
    DateTime closingTime;
}

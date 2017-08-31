/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.shapesandperimeters;

/**
 *
 * @author asmat
 */
public abstract class Shape {
    
    protected String color;
    protected int area;
    protected int perimeter;
    
    abstract public double getArea();
    abstract public double getPerimeter();
    
}

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
public class Triangle extends Shape{
    
    private double base;
    private double height;
    private double side1;
    private double side2;
    
    public Triangle(double x, double y, double base, double height)
    {
        this.side1 = x;
        this.side2 = y;
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return (base * height)/2;
    }

    @Override
    public double getPerimeter() {
        return (side1 + side2 + base);
    }
    
    
}

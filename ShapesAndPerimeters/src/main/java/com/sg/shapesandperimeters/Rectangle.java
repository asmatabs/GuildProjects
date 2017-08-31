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
public class Rectangle extends Shape{

    double width;
    double height;
            
    Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }
    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*(width + height);
    }
    
}

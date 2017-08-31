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
public class Circle extends Shape{
    double radius;
private final double PI = 3.14159;
    Circle(double radius)
    {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*PI*radius;
    }
    
}

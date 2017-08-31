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
public class Square extends Shape{

    double side;
    public Square(double side) {
        this.side = side;
    }

    
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4*side;
    }
    
}

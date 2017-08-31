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
public class Main {
    public static void main(String[] args) {
        
        double area, perimeter;
        Square sq = new Square(10);
        area = sq.getArea();
        perimeter = sq.getPerimeter();
        
        System.out.println("Squares of size 10!");
        System.out.println(area);
        System.out.println(perimeter);
        
        Shape s = new Triangle(10,5,15,10);
        area = s.getArea();
        perimeter = s.getPerimeter();
        
        System.out.println("Triangle with sides 10, 5 and 15!");
        System.out.println(area);
        System.out.println(perimeter);
        
        s = new Circle(10);
        area = s.getArea();
        perimeter = s.getPerimeter();
        
        System.out.println("Circle with radius 10!");
        System.out.println(area);
        System.out.println(perimeter);
        
        s = new Rectangle(10, 30);
        area = s.getArea();
        perimeter = s.getPerimeter();
        
        System.out.println("Rectangle with sides 10, 30!");
        System.out.println(area);
        System.out.println(perimeter);       
    }
}

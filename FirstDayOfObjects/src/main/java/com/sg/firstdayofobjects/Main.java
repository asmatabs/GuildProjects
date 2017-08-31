/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.firstdayofobjects;

/**
 *
 * @author asmat
 */
public class Main {
    public static void main(String[] args) {
        TacoShell crispy = new TacoShell();
        crispy.name = "Crispy";
        
        Menu menu = new Menu(9);
        
        for (int i =0; i<=22; i++)
        {
            Taco t = new Taco();
            t.setName(String.format("Taco #%s ", i+1));
            t.setTacoShell(crispy);
            if(menu.add(t))
            {
                System.out.printf("%s was successfully added \n", t.getName());
            }
            else
            {
                System.out.printf("%s was not added \n", t.getName());
            }
            
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Alice {

    public static void main(String[] args) throws Exception {
        String name = "Alice";
        String delims = "[ .,!\")_*||(\':?;-]+";
        String tokens[]={""};
        int count = 0;

        Scanner sc = new Scanner(
                new BufferedReader(new FileReader("alice1.txt")));

        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();
            tokens = currentLine.split(delims);
            
            for (int i = 0; i < tokens.length; i++){
                if (tokens[i].equalsIgnoreCase(name)){
                    count = count + 1;
                }
            }
            
        }
        
        System.out.println(count);
            
    }
}

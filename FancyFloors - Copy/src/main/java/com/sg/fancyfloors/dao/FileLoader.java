/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author asmat
 */
public class FileLoader {

    private Scanner scanner;

    public File[] FilesByPattern(String pattern) {
        
        File dir = new File(".\\");
        return dir.listFiles((File pathname) -> pathname.getName().contains(pattern));
    }

    public void FileHandle(String fileName)
            throws FilePersistenceException {
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(fileName)));
        } catch (FileNotFoundException e) {
            throw new FilePersistenceException(
                    "-_- Could not load file from memory.", e);
        }
    }

    public String[] FileReader(String delim, int noTokens) {
        String[] tokens = null;

        if (scanner.hasNextLine()) {
            tokens = new String[noTokens];
            String currentLine = scanner.nextLine();
            tokens = currentLine.split(delim);
        }

        return tokens;
    }

    public void FileClose() {
        scanner.close();
    }

}

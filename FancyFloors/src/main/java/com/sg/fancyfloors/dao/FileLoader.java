/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class FileLoader {

    private Scanner scanner;
    private PrintWriter out;
    public Properties properties;

    public File[] FilesByPattern(String pattern) {

        File dir = new File(".\\");
        return dir.listFiles((File pathname) -> pathname.getName().contains(pattern));
    }

    public void FileReaderHandle(String fileName)
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
            tokens = currentLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        }
        return tokens;
    }

    public void FileReaderClose() {
        scanner.close();
    }

    public boolean checkFileExists(String fileName) {
        File f = new File(fileName);
        return f.exists() && !f.isDirectory();
    }

    public void FileWriterHandle(String fileName) throws FilePersistenceException {
        try {
            out = new PrintWriter(new FileWriter(fileName));
        } catch (IOException ex) {
            throw new FilePersistenceException(
                    "-_- Could not load file from memory.", ex);
        }
    }

    public void FileWriter(String line) {
        out.print(line);
        out.flush();
    }

    public void FileWriterClose() {
        out.close();
    }
}

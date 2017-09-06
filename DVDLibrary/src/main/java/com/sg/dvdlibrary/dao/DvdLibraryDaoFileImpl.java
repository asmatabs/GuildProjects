/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author asmat
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    private Map<String, Dvd> dvds = new HashMap<>();
    public static final String DVD_FILE = "DVD.txt";
    public static final String DELIMITER = "::";

    @Override
    public Dvd addDvd(String title, Dvd dvd) {
        Dvd newDvd = dvds.put(title, dvd);
        return newDvd;
    }

    @Override
    public Dvd removeDvd(String title) {
        Dvd removedDvd = dvds.remove(title);
        return removedDvd;
    }

    @Override
    public List<Dvd> getAllDvds() {
        return new ArrayList<>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) {
        return dvds.get(title);
    }

    @Override
    public boolean checkDVDExists(String title) {
        return dvds.containsKey(title);
    }

    @Override
    public void loadDvdData() throws DvdLibraryDaoException {

        Scanner scanner;
        String[] tokens;
        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException(
                    "-_- Could not load DVD data from memory.", e);
        }
        String currentLine;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            tokens = currentLine.split(DELIMITER);
            Dvd currentDvd = new Dvd();
            currentDvd.setTitle(tokens[0]);
            currentDvd.setReleaseDate(tokens[1]);
            currentDvd.setDirector(tokens[2]);
            currentDvd.setStudio(tokens[3]);
            currentDvd.setMpaaRating(tokens[4]);
            if (tokens.length > 5)
            {
                currentDvd.setNote(tokens[5]);  
            }
            else
            {
                currentDvd.setNote("");
            }

            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        scanner.close();
    }

    /**
     *
     * @throws DvdLibraryDaoException
     */
    @Override
    public void writeDvdData() throws DvdLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException ex) {
            throw new DvdLibraryDaoException(
                    "Could not save DVD data into memory", ex);
        }
        
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            out.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getDirector() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getMpaaRating()+ DELIMITER
                    + currentDvd.getNote());
            out.flush();
        }
        out.close();
    }
}

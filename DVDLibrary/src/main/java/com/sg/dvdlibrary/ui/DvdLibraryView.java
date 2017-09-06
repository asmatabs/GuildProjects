/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author asmat
 */
public class DvdLibraryView {

    UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int displayMenuAndGetSelection() {
        io.print("MENU");
        io.print("1 - Add a DVD ");
        io.print("2 - Remove a DVD");
        io.print("3 - Edit a DVD Information");
        io.print("4 - View a DVD information");
        io.print("5 - List DVDs");
        io.print("6 - Save session");
        io.print("7 - Exit");

        return io.readInt("Please select from the"
                + " above choices:", 1, 7);
    }

    public Dvd getDvdInfo() {
        io.print("Enter DVD details");
        Dvd dvd = new Dvd();
        dvd.setTitle(io.readString("Title"));
        dvd.setReleaseDate(io.readString("Release Date"));
        dvd.setMpaaRating(io.readString("MPAA Rating"));
        dvd.setDirector(io.readString("Director"));
        dvd.setStudio(io.readString("Studio"));
        dvd.setNote(io.readString("Note"));

        return dvd;
    }

    public String getDvdTitle() {
        return io.readString("Enter the Title of the DVD:");
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            io.print("Title:" + currentDvd.getTitle());
            io.print("Release Date:" + currentDvd.getReleaseDate());
            io.print("MPAA Rating:" + currentDvd.getMpaaRating());
            io.print("Director:" + currentDvd.getDirector());
            io.print("Studio:" + currentDvd.getStudio());
            io.print("Note:" + currentDvd.getNote());
            io.print("");
        }
    }

    public void displayDvd(Dvd currentDvd) {
        io.print("Title:" + currentDvd.getTitle());
        io.print("Release Date:" + currentDvd.getReleaseDate());
        io.print("MPAA Rating:" + currentDvd.getMpaaRating());
        io.print("Director:" + currentDvd.getDirector());
        io.print("Studio:" + currentDvd.getStudio());
        io.print("Note:" + currentDvd.getNote());
        io.print("");
    }

    public void displayMessage(String msg) {
        io.print(msg);
    }

    public void displayErrorMessage(String message) {
        io.print("ERROR:" + message);
    }
}

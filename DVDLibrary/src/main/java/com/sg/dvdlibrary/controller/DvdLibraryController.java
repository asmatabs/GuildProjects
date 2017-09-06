/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.DvdLibraryView;
import com.sg.dvdlibrary.ui.UserIO;
import com.sg.dvdlibrary.ui.UserIOConsoleImpl;
import com.sg.dvdlibrary.ui.util.DvdConstants;
import java.util.List;

/**
 *
 * @author asmat
 */
public class DvdLibraryController {

    DvdLibraryView view;
    DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryView view, DvdLibraryDao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {
        int menuOption = 0;
        boolean exitApp = false;

        try {
            loadDvd();
            printWelcome();
            do {
                menuOption = displayMenu();
                switch (menuOption) {
                    case 1:
                        addDvd();
                        break;
                    case 2:
                        removeDvd();
                        break;
                    case 3:
                        editDvd();
                        break;
                    case 4:
                        viewDvd();
                        break;
                    case 5:
                        listDvds();
                        break;
                    case 6:
                        saveSession();
                        break;
                    case 7:
                        exitApp = true;
                        break;
                    default:
                        unknownCommand();
                }
            } while (!exitApp);
        } catch (NumberFormatException | DvdLibraryDaoException nfe) {
            view.displayErrorMessage(nfe.getMessage());
        } finally {
            try {
                view.displayMessage(DvdConstants.EXIT_BANNER);
                writeDvd();
            } catch (DvdLibraryDaoException ex) {
                view.displayErrorMessage(ex.getMessage());
            }
        }
    }

    private int displayMenu() {
        return view.displayMenuAndGetSelection();
    }

    private void unknownCommand() {
        view.displayMessage(DvdConstants.UNKNOWN_COMMAND);
    }

    private void printWelcome() {
        view.displayMessage(DvdConstants.WELCOME_BANNER);
    }

    private void addDvd() {
        view.displayMessage(DvdConstants.ADD_DVD_BANNER);
        Dvd newDvd = view.getDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
    }

    private void removeDvd() {
        view.displayMessage(DvdConstants.REMOVE_DVD_BANNER);
        String title = view.getDvdTitle();
        if (dao.checkDVDExists(title)) {
            dao.removeDvd(title);
        } else {
            view.displayMessage(DvdConstants.NO_DVD_FOUND);
        }
    }

    private void editDvd() {
        view.displayMessage(DvdConstants.EDIT_DVD_BANNER);
        String title = view.getDvdTitle();
        Dvd currentDvd = dao.getDvd(title);
        if (null != currentDvd) {
            view.displayMessage(DvdConstants.EDIT_PROMPT);
            Dvd changedDvd = view.getDvdInfo();

            //Update any blank fields in the changedDvd with currentDvd obj
            if (changedDvd.getTitle().isEmpty()) {
                changedDvd.setTitle(currentDvd.getTitle());
            }
            if (changedDvd.getReleaseDate().isEmpty()) {
                changedDvd.setReleaseDate(currentDvd.getReleaseDate());
            }
            if (changedDvd.getDirector().isEmpty()) {
                changedDvd.setDirector(currentDvd.getDirector());
            }
            if (changedDvd.getMpaaRating().isEmpty()) {
                changedDvd.setMpaaRating(currentDvd.getMpaaRating());
            }
            if (changedDvd.getNote().isEmpty()) {
                changedDvd.setNote(currentDvd.getNote());
            }
            if (changedDvd.getStudio().isEmpty()) {
                changedDvd.setStudio(currentDvd.getStudio());
            }

            dao.removeDvd(currentDvd.getTitle());
            dao.addDvd(changedDvd.getTitle(), changedDvd);

        } else {
            view.displayMessage(DvdConstants.NO_DVD_FOUND);
        }
    }

    private void viewDvd() {
        view.displayMessage(DvdConstants.VIEW_DVD_BANNER);
        String title = view.getDvdTitle();
        Dvd currentDvd = dao.getDvd(title);
        if (null != currentDvd) {
            view.displayDvd(currentDvd);
        } else {
            view.displayMessage(DvdConstants.NO_DVD_FOUND);
        }
    }

    private void listDvds() {
        view.displayMessage(DvdConstants.LIST_ALL_DVDS_BANNER);
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void loadDvd() throws DvdLibraryDaoException {
        dao.loadDvdData();
    }

    private void writeDvd() throws DvdLibraryDaoException {
        dao.writeDvdData();
    }

    private void saveSession() throws DvdLibraryDaoException {
        view.displayMessage(DvdConstants.SAVE_SESSION);
        dao.writeDvdData();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.directoryapplication.controller;

import com.sg.directoryapplication.dto.Person;
import com.sg.directoryapplication.service.DirectoryApplicationDataValidationException;
import com.sg.directoryapplication.service.DirectoryApplicationDuplicateIdException;
import com.sg.directoryapplication.service.DirectoryApplicationServiceLayer;
import com.sg.directoryapplication.ui.DirectoryApplicationView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asmat
 */
public class DirectoryApplicationController {

    private DirectoryApplicationView view;
    private DirectoryApplicationServiceLayer service;

    public DirectoryApplicationController(DirectoryApplicationServiceLayer service, DirectoryApplicationView view) {
        this.view = view;
        this.service = service;
    }

    public void run() {

        boolean keepGoing = true;
        int menuSelection = 0;

        while (keepGoing) {
            menuSelection = getSelection();

            switch (menuSelection) {
                case 1:
                    listDirectory();
                    break;
                case 2:
                    createPerson();
                    break;
                case 3:
                    viewPersonDetails();
                    break;
                case 4:
                    removePerson();
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }
        }

        exitMessage();
    }

    private int getSelection() {
        return view.PrintMenuAndGetSelection();
    }

    private void listDirectory() {
        view.displayDisplayAllBanner();
        List<Person> personList = service.getAllPersons();
        view.displayPersonList(personList);
    }

    private void createPerson() {
        boolean hasErrors = false;
        do {
            Person newPerson = view.getNewPersonInfo();
            try {
                service.createPerson(newPerson);
            } catch (DirectoryApplicationDuplicateIdException | DirectoryApplicationDataValidationException ex) {
                hasErrors = true;
                view.displayErrorMessage(ex.getMessage());
            }
        } while (hasErrors);
        view.displayCreateSuccessBanner();
    }

    private void viewPersonDetails() {
        int personId = view.getPersonIdChoice();
        Person person = service.getPerson(personId);
        view.displayPerson(person);
    }

    private void removePerson() {
        int personId = view.getPersonIdChoice();
        service.removePerson(personId);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.directoryapplication.ui;

import com.sg.directoryapplication.dto.Person;
import java.util.List;

/**
 *
 * @author asmat
 */
public class DirectoryApplicationView {

    private UserIO io; // = new UserIOConsoleImpl();

    public DirectoryApplicationView(UserIO io) {
        this.io = io;
    }

    public int PrintMenuAndGetSelection() {

        io.print("Main Menu");
        io.print("1. List Directory");
        io.print("2. Create New Directory Entry");
        io.print("3. View a Person's detail");
        io.print("4. Remove a Person from the directory");
        io.print("5. Exit");

        return io.readInt("Please select from the"
                + " above choices.", 1, 5);
    }

    public Person getNewPersonInfo() {
        int personId = io.readInt("Please enter an ID:");
        String name = io.readString("Please enter a name:");
        String street = io.readString("Please enter street address:");
        Long phone = io.readLong("Please enter a phone number");
        Person currentPerson = new Person(personId);
        currentPerson.setName(name);
        currentPerson.setStreet(street);
        currentPerson.setPhoneNum(phone);
        return currentPerson;
    }

//    public void displayCreateStudentBanner() {
//        io.print("=== Create Student ===");
//    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Student successfully created.  Please hit enter to continue");
    }

    public void displayPersonList(List<Person> personList) {
        for (Person currentPerson : personList) {
            io.print(currentPerson.getId()+ ": "
                    + currentPerson.getName()+ " "
                    + currentPerson.getStreet()+ " "
                    + currentPerson.getPhoneNum());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Persons ===");
    }

//    public void displayDisplayStudentBanner() {
//        io.print("=== Display Student ===");
//    }

    public int getPersonIdChoice() {
        return io.readInt("Please enter the Person ID.");
    }

    public void displayPerson(Person person) {
        if (person != null) {
            io.print(Integer.toString(person.getId()));
            io.print(person.getName());
            io.print(person.getStreet());
            io.print(person.getPhoneNum().toString());
            io.print("");
        } else {
            io.print("No such Person.");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemovePersonBanner() {
        io.print("=== Remove Person ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Person successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String msg) {
        io.print(msg);
    }

//    public void displayStudentList(List<Person> personList) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}

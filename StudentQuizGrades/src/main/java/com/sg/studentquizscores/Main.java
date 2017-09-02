/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.io.IOException;

/**
 *
 * @author asmat
 */
public class Main {

    public static void main(String[] args) throws IOException {

        UserIO io = new UserIOImpl();
        io.print("Welcome to the Student portal");
        
        StudentInfo studentInfo = new StudentInfo();

        //Unmarshall and load the map here!!
        studentInfo.loadData();
        boolean exitPortal = false;
        do {
            int option = menu();
            switch (option) {
                case 1:
                    studentInfo.listStudents();
                    break;
                case 2:
                    studentInfo.addStudent();
                    break;
                case 3:
                    studentInfo.removeStudent(io.readString("Enter student name:"));
                    break;
                case 4:
                    studentInfo.studentQuizScores(io.readString("Enter student name:"));
                    break;
                case 5:
                    studentInfo.avgStudentQuizScores(io.readString("Enter student name:"));
                    break;
                default:
                    exitPortal = true;
            }
        } while (!exitPortal);

        //Marshall the data
        io.print("Please wait while the changes are saved...");
        studentInfo.saveChanges();

        io.print("Thanks for using the Student portal!");

    }

    public static int menu() {
        UserIO io = new UserIOImpl();

        io.print("Please select from the following options...");

        io.print("1 - List Students");
        io.print("2 - Add a new student");
        io.print("3 - Remove a Student");
        io.print("4 - View quiz scores for a student");
        io.print("5 - View average scores for a student");
        io.print("Any other key to exit the portal..");

        return io.readInt("Your Choice: ");
    }

}

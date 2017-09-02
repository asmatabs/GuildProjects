/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 *
 * @author asmat
 */
public class StudentInfo {

    int[] scores;
    HashMap<String, int[]> quizScores;
    UserIO io = new UserIOImpl();
    public final int SUBJECTS = 5;

    public StudentInfo()
    {
       quizScores = new HashMap<>(); 
       io = new UserIOImpl();
       scores = new int[5];
    }
    public void listStudents() {
        Set<String> students = quizScores.keySet();
        for (String s : students) {
            io.print("Student Name: " + s);
        }
    }

    public void addStudent() {

        String name = io.readString("Student name: ");
        int[] scores = new int[SUBJECTS];
        for (int i = 0; i < SUBJECTS; i++) {
            scores[i] = io.readInt("Enter score for subject " + (i + 1));
        }
        quizScores.put(name, scores);
    }

    public void removeStudent(String studentName) {

        io.print("Removing " + studentName + " from the system.");
        String ans = io.readString("Are you sure about this?(y/n)");
        if (ans.equalsIgnoreCase("y")) {
            quizScores.remove(studentName);
        }
    }

    public void studentQuizScores(String studentName) {
        int[] scores = quizScores.get(studentName);
        io.print("Quiz scores - ");
        for (int i = 0; i < scores.length; i++) {
            io.print(scores[i] + " ");
        }
    }

    public void avgStudentQuizScores(String studentName) {
        int[] scores = quizScores.get(studentName);
        int avg = IntStream.of(scores).sum() / SUBJECTS;
        io.print("Quiz scores - " + avg);
    }

    public void loadData() throws FileNotFoundException {
        Scanner sc = new Scanner(
                new BufferedReader(new FileReader("OutFile.txt")));
        System.out.println("Opening file to load data...");
        // go through the file line by line
        while (sc.hasNextLine()) {
            System.out.println("Found a record to load");
            String currentLine = sc.nextLine();
            
            String delim = "::";
            String[] split = currentLine.split(delim);
            System.out.println(split[0]);
            String studentName = split[0];
            int[] scores = new int[5];
            for (int i = 1; i < split.length; i++)
            {
                scores[i-1] = Integer.valueOf(split[i]);
            }
            quizScores.put(studentName, scores);
        }
    }

    public void saveChanges() throws IOException {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));

            Set<String> students = quizScores.keySet();
            for (String s : students) {
                System.out.println("Saving " + s);
                out.print(s);
                int[] scores = quizScores.get(s);
                for (int i = 0; i < scores.length; i++) {
                    out.print("::" + scores[i]);
                }
                out.println();
                // out.print(quizScores.get(s));
            }

            out.flush();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(StudentInfo.class.getName()).log(Level.SEVERE, null, ex);

        }

    }
}

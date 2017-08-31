/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizscores;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.IntStream;

/**
 *
 * @author asmat
 */
public class StudentInfo {

    int[] scores = new int[5];
    HashMap<String, int[]> quizScores = new HashMap<>();
    UserIO io = new UserIOImpl();
    public final int SUBJECTS = 5;

    public void listStudents() {
        Set<String> students = quizScores.keySet();
        for (String s : students) {
            io.print("Student Name: " + s.toUpperCase());
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
}

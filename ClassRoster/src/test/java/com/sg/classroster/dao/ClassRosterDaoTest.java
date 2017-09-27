/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.classroster.dao;

import com.sg.classroster.dto.Student;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asmat
 */
public class ClassRosterDaoTest {

    private ClassRosterDao dao = new ClassRosterDaoFileImpl();

    public ClassRosterDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<Student> studentList = dao.getAllStudents();
        for (Student student : studentList) {
            dao.removeStudent(student.getStudentId());
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addStudent method, of class ClassRosterDao.
     */
    @Test
    public void testAddGetStudent() throws Exception {
        Student student = new Student("0001");
        student.setFirstName("Joe");
        student.setLastName("Smith");
        student.setCohort("Java-May-2000");

        dao.addStudent(student.getStudentId(), student);

        Student newStudent = dao.getStudent(student.getStudentId());

        assertEquals(newStudent, student);
    }

    /**
     * Test of getAllStudents method, of class ClassRosterDao.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        Student student1 = new Student("0001");
        student1.setFirstName("Joe");
        student1.setLastName("Smith");
        student1.setCohort("Java-May-2000");

        dao.addStudent(student1.getStudentId(), student1);

        Student student2 = new Student("0002");
        student2.setFirstName("John");
        student2.setLastName("Doe");
        student2.setCohort("Java-May-2000");

        dao.addStudent(student2.getStudentId(), student2);

        List<Student> studentList = dao.getAllStudents();
        assertEquals(2, studentList.size());
    }

    /**
     * Test of removeStudent method, of class ClassRosterDao.
     */
//    @Test
//    public void testRemoveStudent() throws Exception {
//        Student student1 = new Student("0001");
//        student1.setFirstName("Joe");
//        student1.setLastName("Smith");
//        student1.setCohort("Java-May-2000");
//
//        dao.addStudent(student1.getStudentId(), student1);
//
//        Student student2 = new Student("0002");
//        student2.setFirstName("John");
//        student2.setLastName("Doe");
//        student2.setCohort("Java-May-2000");
//
//        dao.addStudent(student2.getStudentId(), student2);
//
//        dao.removeStudent(student1.getStudentId());
//        System.out.println(dao.getAllStudents().size());
//        //assertEquals(1, dao.getAllStudents().size());
//        assertNull(dao.getStudent(student1.getStudentId()));
//
//        dao.removeStudent(student2.getStudentId());
//        System.out.println(dao.getAllStudents().size());
//       // assertEquals(0, dao.getAllStudents().size());
//        assertNull(dao.getStudent(student2.getStudentId()));
//    }
}

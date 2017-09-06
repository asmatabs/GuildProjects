/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.directoryapplication.service;

import com.sg.directoryapplication.dto.Person;
import java.util.List;

/**
 *
 * @author asmat
 */
public interface DirectoryApplicationServiceLayer {
     void createPerson(Person person) throws
            DirectoryApplicationDuplicateIdException,
            DirectoryApplicationDataValidationException;
 
    List<Person> getAllPersons();
 
    Person getPerson(int personId);
 
    Person removePerson(int personId);  
}

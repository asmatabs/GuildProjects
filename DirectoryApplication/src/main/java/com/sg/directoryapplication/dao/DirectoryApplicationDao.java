/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.directoryapplication.dao;

import com.sg.directoryapplication.dto.Person;
import java.util.List;

/**
 *
 * @author asmat
 */
public interface DirectoryApplicationDao {

    Person addPerson(int personId, Person person);


    List<Person> getAllPersons();


    Person getPerson(int personId);


    Person removePerson(int personId) ;

}

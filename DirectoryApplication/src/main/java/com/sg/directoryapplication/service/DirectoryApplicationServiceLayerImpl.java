/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.directoryapplication.service;

import com.sg.directoryapplication.dao.DirectoryApplicationDao;
import com.sg.directoryapplication.dto.Person;
import java.util.List;

/**
 *
 * @author asmat
 */
public class DirectoryApplicationServiceLayerImpl implements DirectoryApplicationServiceLayer {

    DirectoryApplicationDao dao;

    public DirectoryApplicationServiceLayerImpl(DirectoryApplicationDao dao) {
        this.dao = dao;
    }

    @Override
    public void createPerson(Person person) throws DirectoryApplicationDuplicateIdException,
            DirectoryApplicationDataValidationException {
        if (dao.getPerson(person.getId()) != null) {
            //Person Already exists, throw exception
            throw new DirectoryApplicationDuplicateIdException("ERROR: Could not create Person. Person ID "
                    + person.getId() + " already exists");
        }
        validatePersonDetails(person);
        dao.addPerson(person.getId(), person);
    }

    @Override
    public List<Person> getAllPersons() {
        return dao.getAllPersons();
    }

    @Override
    public Person getPerson(int personId) {
        return dao.getPerson(personId);
    }

    @Override
    public Person removePerson(int personId) {
        return dao.removePerson(personId);
    }

    private void validatePersonDetails(Person person) throws
            DirectoryApplicationDataValidationException {

        if (person.getId()== 0
                || person.getName().trim().length() == 0
                || person.getStreet()== null
                || person.getPhoneNum() == 0)

            throw new DirectoryApplicationDataValidationException(
                    "ERROR: All fields [Id, Name, Street Address, Phone Number] are required.");
        }
}

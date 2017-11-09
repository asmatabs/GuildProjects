/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistspringmvc.dao;

import com.sg.contactlistspringmvc.model.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author asmat
 */
public class ContactListDaoInMemImpl implements ContactListDao {

    private Map<Long, Contact> contactMap = new HashMap<>();
    private static long contactIdCounter = 0;

    @Override
    public Contact addContact(Contact contact) {
        contact.setContactId(contactIdCounter);
        contactIdCounter++;
        contactMap.put(contact.getContactId(), contact);
        return contact;
    }

    @Override
    public void removeContact(long contactId) {
        contactMap.remove(contactId);
    }

    @Override
    public void updateContact(Contact contact) {
        contactMap.put(contact.getContactId(), contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return new ArrayList(contactMap.values());
    }

    @Override
    public Contact getContactById(long contactId) {
        return contactMap.get(contactId);
    }

    @Override
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria) {
        String firstNameSearchCriteria = criteria.get(SearchTerm.FIRST_NAME);
        String lastNameSearchCriteria = criteria.get(SearchTerm.LAST_NAME);
        String companySearchCriteria = criteria.get(SearchTerm.COMPANY);
        String phoneSearchCriteria = criteria.get(SearchTerm.PHONE);
        String emailSearchCriteria = criteria.get(SearchTerm.EMAIL);

//        Predicate<Contact> firstNameMatchPredicate;
//        Predicate<Contact> lastNameMatchPredicate;
//        Predicate<Contact> companyMatchPredicate;
//        Predicate<Contact> phoneMatchPredicate;
//        Predicate<Contact> emailMatchPredicate;
//
//        Predicate<Contact> truePredicate = (c) -> {
//            return true;
//        };
//
//        if (firstNameSearchCriteria == null || firstNameSearchCriteria.isEmpty()) {
//            firstNameMatchPredicate = truePredicate;
//        } else {
//            firstNameMatchPredicate = (c) -> (c).getFirstName().equals(firstNameSearchCriteria);
//        }
//
//        if (lastNameSearchCriteria == null || lastNameSearchCriteria.isEmpty()) {
//            lastNameMatchPredicate = truePredicate;
//        } else {
//            lastNameMatchPredicate = (c) -> (c).getLastName().equals(lastNameSearchCriteria);
//        }
//
//        if (companySearchCriteria == null || companySearchCriteria.isEmpty()) {
//            companyMatchPredicate = truePredicate;
//        } else {
//            companyMatchPredicate  = (c) -> c.getCompany().equals(companySearchCriteria);
//        }
//
//        if (phoneSearchCriteria == null || phoneSearchCriteria.isEmpty()) {
//            phoneMatchPredicate = truePredicate;
//        } else {
//            phoneMatchPredicate  = (c) -> c.getPhone().equals(phoneSearchCriteria);
//        }
//
//        if (emailSearchCriteria == null || emailSearchCriteria.isEmpty()) {
//            emailMatchPredicate = truePredicate;
//        } else {
//            emailMatchPredicate  = (c) -> c.getEmail().equals(emailSearchCriteria);
//        }
        
        Stream<Contact> query = getAllContacts().stream();
        
        if(firstNameSearchCriteria != null && firstNameSearchCriteria.length() > 0) {
            query = query.filter((c) -> c.getFirstName().contains(firstNameSearchCriteria));
        }
        
        if(lastNameSearchCriteria != null && lastNameSearchCriteria.length() > 0)   {
            query = query.filter(c -> c.getLastName().contains(lastNameSearchCriteria));
        }
        
        if (companySearchCriteria != null && companySearchCriteria.length() > 0) {
            query = query.filter((c) -> c.getCompany().contains(companySearchCriteria));
        }
        
        if (phoneSearchCriteria != null && phoneSearchCriteria.length() > 0) {
            query = query.filter((c) -> c.getPhone().contains(phoneSearchCriteria));
        }

        if (emailSearchCriteria != null && emailSearchCriteria.length() > 0) {
            query = query.filter((c) -> c.getEmail().contains(emailSearchCriteria));
        }
        
        return query.collect(Collectors.toList());
        
//                return contactMap.values().stream()
//                .filter(firstNameMatchPredicate
//                        .and(lastNameMatchPredicate)
//                        .and(companyMatchPredicate)
//                        .and(phoneMatchPredicate)
//                        .and(emailMatchPredicate))
//                .collect(Collectors.toList());
    }
 }

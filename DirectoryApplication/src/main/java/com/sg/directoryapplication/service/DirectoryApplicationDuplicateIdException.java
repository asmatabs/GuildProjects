/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.directoryapplication.service;

/**
 *
 * @author asmat
 */
public class DirectoryApplicationDuplicateIdException extends Exception {

    public DirectoryApplicationDuplicateIdException(String message) {
        super(message);
    }

    public DirectoryApplicationDuplicateIdException(String message,
            Throwable cause) {
        super(message, cause);
    }
}

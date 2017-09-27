/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.advice;

import com.sg.vendingmachine.dao.FilePersistenceException;
import com.sg.vendingmachine.service.InsufficientFundsException;
import com.sg.vendingmachine.service.NoItemInventoryException;
import com.sg.vendingmachine.service.VendingMachineAudit;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author asmat
 */
public class LoggingAdvice {

    VendingMachineAudit audit;

    public LoggingAdvice(VendingMachineAudit audit) {
        this.audit = audit;
    }

    public void createAuditEntry(JoinPoint jp, Object retVal ) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
            auditEntry += "\t";
        }
        auditEntry += "\n Returning: ";
        auditEntry += retVal;
        try {
            audit.writeAuditEntry(auditEntry);
        } catch (FilePersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    public void createExceptionEntry(JoinPoint jp, Throwable exception) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        auditEntry += "An error has occured: "; 
        if (exception instanceof InsufficientFundsException || exception instanceof NoItemInventoryException)
        {
            auditEntry += exception.getMessage();
        }
        else
        {
            auditEntry += exception.getStackTrace();
        }
        try {
            audit.writeAuditEntry(auditEntry);
        } catch (FilePersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}

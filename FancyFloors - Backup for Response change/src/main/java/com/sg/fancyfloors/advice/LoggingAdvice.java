/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.fancyfloors.advice;

import com.sg.fancyfloors.dao.FilePersistenceException;
import com.sg.fancyfloors.service.FlooringOrdersAudit;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author asmat
 */
public class LoggingAdvice {

    FlooringOrdersAudit audit;

    public LoggingAdvice(FlooringOrdersAudit audit) {
        this.audit = audit;
    }

    public void createAuditEntry(JoinPoint jp, Object retVal) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        auditEntry += "\nREQUEST: ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
            auditEntry += "\t";
        }
        auditEntry += "\nRESPONSE: ";
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
        auditEntry += "AN ERROR HAS OCCURED: ";
        auditEntry += exception.getMessage();
        try {
            audit.writeAuditEntry(auditEntry);
        } catch (FilePersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}

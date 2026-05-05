package com.project.taskmanager.application.exception;

public class EmptyGroupAssignmentException extends RuntimeException {
    public EmptyGroupAssignmentException(String message) {
        super(message);
    }
}
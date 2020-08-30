package com.homework.exceptions.university.exceptions;

public class StudentHasNoSubjectsException extends Exception {
    public StudentHasNoSubjectsException() {
        super();
    }

    public StudentHasNoSubjectsException(String message) {
        super(message);
    }

    public StudentHasNoSubjectsException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentHasNoSubjectsException(Throwable cause) {
        super(cause);
    }
}

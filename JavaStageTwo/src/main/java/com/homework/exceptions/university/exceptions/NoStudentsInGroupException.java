package com.homework.exceptions.university.exceptions;

public class NoStudentsInGroupException extends Exception {
    public NoStudentsInGroupException() {
        super();
    }

    public NoStudentsInGroupException(String message) {
        super(message);
    }

    public NoStudentsInGroupException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoStudentsInGroupException(Throwable cause) {
        super(cause);
    }
}

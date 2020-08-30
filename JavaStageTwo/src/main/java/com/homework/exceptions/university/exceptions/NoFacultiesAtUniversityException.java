package com.homework.exceptions.university.exceptions;

public class NoFacultiesAtUniversityException extends Exception {
    public NoFacultiesAtUniversityException() {
        super();
    }

    public NoFacultiesAtUniversityException(String message) {
        super(message);
    }

    public NoFacultiesAtUniversityException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoFacultiesAtUniversityException(Throwable cause) {
        super(cause);
    }
}

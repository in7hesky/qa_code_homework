package com.homework.exceptions.university.exceptions;

public class GradeOutOfBoundsException extends Exception {
    public GradeOutOfBoundsException() {
        super();
    }

    public GradeOutOfBoundsException(String message) {
        super(message);
    }

    public GradeOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GradeOutOfBoundsException(Throwable cause) {
        super(cause);
    }
}

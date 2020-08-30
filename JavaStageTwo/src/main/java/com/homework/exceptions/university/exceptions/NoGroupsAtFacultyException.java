package com.homework.exceptions.university.exceptions;

public class NoGroupsAtFacultyException extends Exception {
    public NoGroupsAtFacultyException() {
        super();
    }

    public NoGroupsAtFacultyException(String message) {
        super(message);
    }

    public NoGroupsAtFacultyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoGroupsAtFacultyException(Throwable cause) {
        super(cause);
    }
}

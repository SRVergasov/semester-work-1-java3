package ru.kpfu.itis.java3.semesterwork1.exceptions;

public class DBException extends RuntimeException {
    // TODO upgrade message
    public DBException() {
        super();
    }

    public DBException(String message) {
        super(message);
    }
}

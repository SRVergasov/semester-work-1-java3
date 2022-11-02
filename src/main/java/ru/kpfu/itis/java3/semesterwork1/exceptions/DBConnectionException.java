package ru.kpfu.itis.java3.semesterwork1.exceptions;

public class DBConnectionException extends RuntimeException {
    public DBConnectionException() {
        super();
    }

    public DBConnectionException(String message) {
        super(message);
    }
}

package ru.kpfu.itis.java3.semesterwork1.exceptions;

public class PropertyLoadException extends RuntimeException {
    public PropertyLoadException() {
        super();
    }

    public PropertyLoadException(String message) {
        super(message);
    }
}

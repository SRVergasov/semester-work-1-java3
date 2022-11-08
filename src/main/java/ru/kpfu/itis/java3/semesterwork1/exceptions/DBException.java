package ru.kpfu.itis.java3.semesterwork1.exceptions;

import javax.ws.rs.DELETE;
import java.sql.SQLException;

public class DBException extends Exception {

    public DBException() {
        super();
    }

    public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBException(Throwable cause) {
        super(cause);
    }
}

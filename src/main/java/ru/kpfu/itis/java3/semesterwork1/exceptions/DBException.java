package ru.kpfu.itis.java3.semesterwork1.exceptions;

import javax.ws.rs.DELETE;
import java.sql.SQLException;

public class DBException extends RuntimeException {

    public DBException() {
        super();
    }

    public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

    @Deprecated
    public DBException(SQLException ex) {
        this(new StringBuffer(ex.getMessage())
                .append(" db state:")
                .append(ex.getSQLState())
                .append(" error code:")
                .append(ex.getErrorCode()).toString());
    }

}

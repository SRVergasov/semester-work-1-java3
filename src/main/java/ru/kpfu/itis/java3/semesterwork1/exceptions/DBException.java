package ru.kpfu.itis.java3.semesterwork1.exceptions;

import java.sql.SQLException;

public class DBException extends RuntimeException {
    private String dbState;

    public DBException() {
        super();
    }

    public DBException(String message) {
        super(message);
    }

    public DBException(SQLException ex) {
        this(new StringBuffer(ex.getMessage())
                .append(" db state:")
                .append(ex.getSQLState())
                .append(" error code:")
                .append(ex.getErrorCode()).toString());
        this.dbState = ex.getSQLState();
    }

    public String getDbState() {
        return dbState;
    }
}

package ru.kpfu.itis.java3.semesterwork1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection INSTANCE = null;

    private DBConnection() {

    }

    public static Connection getInstance(String url, String dbName, String username, String password) {
        if (INSTANCE == null) {
            try {
                INSTANCE = DriverManager.getConnection(url + dbName, username, password);
            } catch (SQLException ignored) {
                //TODO handle
            }
        }
        return INSTANCE;
    }

}

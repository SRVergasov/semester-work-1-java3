package ru.kpfu.itis.java3.semesterwork1.listeners;

import ru.kpfu.itis.java3.semesterwork1.db.DBConnection;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBConnectionException;
import ru.kpfu.itis.java3.semesterwork1.exceptions.PropertyLoadException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.Objects;
import java.util.Properties;

@WebListener("")
public class MainWebListener implements ServletContextListener {
    private String url;
    private String username;
    private String password;
    private String driver;
    private String dbName;

    private void initProperties() {
        Properties prop = new Properties();
        try (InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/app.properties")))) {
            prop.load(reader);
            this.url = prop.getProperty("dbUrl");
            this.username = prop.getProperty("dbUsername");
            this.password = prop.getProperty("dbPassword");
            this.driver = prop.getProperty("dbDriver");
            this.dbName = prop.getProperty("dbName");
        } catch (IOException e) {
            throw new PropertyLoadException(this.toString());
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        initProperties();
        sce.getServletContext().setAttribute("dbConnection", initDbConnection());

    }

    private Connection initDbConnection() {
        try {
            Class.forName(driver);
            return DBConnection.getInstance(url, dbName, username, password);
        } catch (ClassNotFoundException e) {
            throw new DBConnectionException(e.getMessage());
        }
    }
}

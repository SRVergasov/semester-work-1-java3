package ru.kpfu.itis.java3.semesterwork1.db;

import ru.kpfu.itis.java3.semesterwork1.entity.Question;
import ru.kpfu.itis.java3.semesterwork1.entity.User;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBProcessor {
    private final Connection conn;
    private PasswordHashProcessor hashProcessor = new PasswordHashProcessor();

    public DBProcessor(Connection conn) {
        this.conn = conn;
    }

    public boolean containsUser(String username) {
        for (User u : getUsersList()) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean authUser(String username, String password) {
        List<User> userList = getUsersList();
        for (User u : userList) {
            if (u.getUsername().equals(username) &&
                    u.getPassword().equals(hashProcessor.generateHashedPassword(password))) {
                return true;
            }
        }
        return false;
    }

    public List<User> getUsersList() {
        ArrayList<User> list = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * from users order by id"
            );
            while (rs.next()) {
                list.add(new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("rating"),
                        rs.getString("role")));
            }
            stmt.close();
            return list;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public User getUserByUsername(String username) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    //TODO more beautiful requests
                    "SELECT * FROM users WHERE username = '" + username + "'"
            );
            if (rs.next()) {
                return new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("rating"),
                        rs.getString("role"));
            }
            throw new DBException("not found");
        } catch (SQLException exception) {
            throw new DBException(exception);
        }
    }

    public User getUserById(int id) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM users WHERE id = " + id
            );
            if (rs.next()) {
                return new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("rating"),
                        rs.getString("role"));
            }
            throw new DBException("not found");
        } catch (SQLException exception) {
            throw new DBException(exception);
        }
    }

    public void setRating(int userId, int rating) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "update users set rating = ? where id = ?"
            );
            stmt.setInt(1, rating);
            stmt.setInt(2, userId);
            stmt.execute();
        } catch (SQLException exception) {
            throw new DBException(exception);
        }
    }

    public void addUser(String username, String password) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "insert into users (username, password) values (?, ?);"
            );
            stmt.setString(1, username);
            stmt.setString(2, hashProcessor.generateHashedPassword(password));
            stmt.execute();
        } catch (SQLException exception) {
            throw new DBException(exception);
        }
    }

    public List<Question> getQuestionsList() {
        ArrayList<Question> list = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * from questions order by id desc"
            );
            while (rs.next()) {
                list.add(new Question(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getInt("user_id")));
            }
            stmt.close();
            return list;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

}

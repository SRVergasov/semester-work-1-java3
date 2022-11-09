package ru.kpfu.itis.java3.semesterwork1.dao;

import ru.kpfu.itis.java3.semesterwork1.entity.User;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;
import ru.kpfu.itis.java3.semesterwork1.utils.PasswordHashGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Connection conn;
    private PasswordHashGenerator hashProcessor;

    public UserDao(Connection conn) {
        this.conn = conn;
        hashProcessor = new PasswordHashGenerator();
    }

    public List<User> getUsersList() throws DBException {
        ArrayList<User> list = new ArrayList<>();
        //TODO date
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * from users")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("rating"),
                        rs.getString("role")));
            }
            return list;
        } catch (SQLException e) {
            throw new DBException("Cannot get users list", e);
        }
    }

    public List<User> getSortedUsersList() throws DBException {
        ArrayList<User> list = new ArrayList<>();
        //TODO date
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * from users order by rating desc")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("rating"),
                        rs.getString("role")));
            }
            return list;
        } catch (SQLException e) {
            throw new DBException("Cannot get users list", e);
        }
    }

    public User getUserByUsername(String username) throws DBException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?")) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("rating"),
                        rs.getString("role"));
            }
            throw new DBException("not found user");
        } catch (SQLException exception) {
            throw new DBException("Cannot get user by username", exception);
        }
    }

    public User getUserById(int id) throws DBException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("rating"),
                        rs.getString("role"));
            }
            throw new DBException("not found user");
        } catch (SQLException exception) {
            throw new DBException("Cannot get user by id", exception);
        }
    }

    public void setRating(int userId, int rating) throws DBException {
        try (PreparedStatement stmt = conn.prepareStatement("update users set rating = ? where id = ?")) {
            stmt.setInt(1, rating);
            stmt.setInt(2, userId);
            stmt.execute();
        } catch (SQLException exception) {
            throw new DBException("Cannot set user rating", exception);
        }
    }

    public void addUser(String username, String password) throws DBException {
        try (PreparedStatement stmt = conn.prepareStatement("insert into users (username, password) values (?, ?);")) {
            stmt.setString(1, username);
            stmt.setString(2, hashProcessor.generateHashedPassword(password));
            stmt.execute();
        } catch (SQLException exception) {
            throw new DBException("Cannot add user", exception);
        }
    }

    public void updateRating(int userId, int value) throws DBException {
        try (PreparedStatement stmt = conn.prepareStatement("update users set rating = rating + ? where id = ?")) {
            stmt.setInt(1, value);
            stmt.setInt(2, userId);
            stmt.execute();
        } catch (SQLException ex) {
            throw new DBException("Cannot update user rating", ex);
        }
    }

    //TODO change logic
    public boolean containsUser(String username) throws DBException {
        for (User u : getUsersList()) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public boolean authUser(String username, String password) throws DBException {
        List<User> userList = getUsersList();
        for (User u : userList) {
            if (u.getUsername().equals(username) &&
                    u.getPassword().equals(hashProcessor.generateHashedPassword(password))) {
                return true;
            }
        }
        return false;
    }
}

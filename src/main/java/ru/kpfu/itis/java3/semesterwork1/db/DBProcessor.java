package ru.kpfu.itis.java3.semesterwork1.db;

import org.apache.commons.codec.digest.DigestUtils;
import ru.kpfu.itis.java3.semesterwork1.entity.User;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBProcessor {
    private final Connection conn;

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
                    u.getPassword().equals(DigestUtils.md5Hex(password))) {
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
            throw new DBException(e.getMessage());
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
            throw new DBException(exception.getMessage());
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
            throw new DBException(exception.getMessage());
        }
    }

//    public void setCity(int userId, String city) {
//        try {
//            PreparedStatement stmt = conn.prepareStatement(
//                    "update users set city = '" + city + "' where id = " + userId
//            );
//            stmt.execute();
//        } catch (SQLException exception) {
//            throw new DBException(exception.getMessage());
//        }
//    }

}

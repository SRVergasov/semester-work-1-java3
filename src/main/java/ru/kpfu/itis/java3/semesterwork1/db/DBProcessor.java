package ru.kpfu.itis.java3.semesterwork1.db;

import org.apache.commons.codec.digest.DigestUtils;
import ru.kpfu.itis.java3.srvergasov.auth.entity.User;
import ru.kpfu.itis.java3.srvergasov.auth.exceptions.DBException;

import java.sql.*;
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
                    "SELECT * from sample_user order by id"
            );
            while (rs.next()) {
                list.add(new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("user_role"),
                        rs.getString("city")));
            }
            stmt.close();
            return list;
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }

    public User getUserByUsername(String username) {
        List<User> userList = getUsersList();
        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public User getUserById(int id) {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM sample_user WHERE id = " + id
            );
            if (rs.next()) {
                return new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("user_role"),
                        rs.getString("city"));
            }
            throw new DBException("not found");
        } catch (SQLException exception) {
            throw new DBException(exception.getMessage());
        }
    }

    public boolean setCity(int userId, String city) {
        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "update sample_user set city = '" + city + "' where id = " + userId
            );
            return stmt.execute();
        } catch (SQLException exception) {
            throw new DBException(exception.getMessage());
        }
    }

}

package ru.kpfu.itis.java3.semesterwork1.entity;

import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String password;
    private String role;
    private String city;

    public User(int id, String username, String password) {
        this(id, username, password, null, null);
    }

    public User(String username, String password, String role) {
        this(0, username, password, role);
    }

    public User(int id, String username, String password, String role) {
        this(id, username, password, role, null);
    }

    public User(int id, String username, String password, String role, String city) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.city = city;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (!Objects.equals(username, user.username)) return false;
        return Objects.equals(password, user.password); // TODO md5
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" + "username='" + username + '\'' + ", city='" + city + '\'' + '}';
    }
}

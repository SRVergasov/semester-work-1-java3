package ru.kpfu.itis.java3.semesterwork1.entity;

import java.util.Objects;

public class User {
    private int id;
    private String username;
    private String password;
    private int rating;

    public User(int id, String username, String password) {
        this(id, username, password, 0);
    }

    public User(int id, String username, String password, int rating) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (rating != user.rating) return false;
        if (!username.equals(user.username)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + rating;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", rating=" + rating +
                '}';
    }
}

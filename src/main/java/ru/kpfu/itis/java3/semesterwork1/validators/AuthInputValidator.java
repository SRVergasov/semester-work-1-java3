package ru.kpfu.itis.java3.semesterwork1.validators;

public class AuthInputValidator {
    private String message = "";

    public boolean validate(String username, String password) {
        // TODO null check
        if (username.isEmpty()) {
            message = "Empty username field";
            return false;
        }
        if (password.isEmpty()) {
            message = "Empty password field";
            return false;
        }
        return true;
    }

    public String getMessage() {
        return message;
    }

}

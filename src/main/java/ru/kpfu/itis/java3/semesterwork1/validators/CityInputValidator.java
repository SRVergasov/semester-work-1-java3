package ru.kpfu.itis.java3.semesterwork1.validators;

//TODO change city to something
public class CityInputValidator {
    private String message = "";

    public boolean validate(String city) {
        // TODO exist check
        if (city == null) {
            message = "City cannot be null";
            return false;
        }
        if (city.isEmpty()) {
            message = "City cannot be empty";
            return false;
        }
        return true;
    }

    public String getMessage() {
        return message;
    }
}

package ru.kpfu.itis.java3.semesterwork1.db;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHashProcessor {

    public String generateHashedPassword(String password) {
        String salt = "</3lullaby?";
        return DigestUtils.md5Hex(password + salt);
    }
}

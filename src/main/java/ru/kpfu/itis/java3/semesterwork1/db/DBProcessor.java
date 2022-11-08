package ru.kpfu.itis.java3.semesterwork1.db;

import ru.kpfu.itis.java3.semesterwork1.entity.Answer;
import ru.kpfu.itis.java3.semesterwork1.entity.Question;
import ru.kpfu.itis.java3.semesterwork1.entity.User;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;
import ru.kpfu.itis.java3.semesterwork1.utils.PasswordHashGenerator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class DBProcessor {
    private final Connection conn;
    private PasswordHashGenerator hashProcessor;

    public DBProcessor(Connection conn) {
        this.conn = conn;
        hashProcessor = new PasswordHashGenerator();
    }

}

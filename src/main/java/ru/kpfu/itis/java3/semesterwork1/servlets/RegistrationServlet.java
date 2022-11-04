package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.db.DBProcessor;
import ru.kpfu.itis.java3.semesterwork1.entity.User;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;
import ru.kpfu.itis.java3.semesterwork1.validators.RegistrationInputValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLType;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    private RegistrationInputValidator registrationInputValidator;
    private DBProcessor dbProcessor;

    @Override
    public void init() throws ServletException {
        registrationInputValidator = new RegistrationInputValidator();
        dbProcessor = new DBProcessor((Connection) getServletContext().getAttribute("dbConnection"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (!registrationInputValidator.validate(username, password)) {
            req.setAttribute("errorText", registrationInputValidator.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
            return;
        }
        if (dbProcessor.containsUser(username)) {
            req.setAttribute("errorText", "username must be unique");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
            return;
        }
        dbProcessor.addUser(username, password);
        User user = dbProcessor.getUserByUsername(username);
        req.getSession().setAttribute("userId", user.getId());
        req.getSession().setAttribute("name", user.getUsername());
        req.getSession().setAttribute("role", user.getRole());
        resp.sendRedirect(getServletContext().getContextPath() +  "/profile");
    }
}

package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.db.DBProcessor;
import ru.kpfu.itis.java3.semesterwork1.entity.User;
import ru.kpfu.itis.java3.semesterwork1.validators.AuthInputValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private AuthInputValidator inputValidator;
    private DBProcessor dbProcessor;

    @Override
    public void init() throws ServletException {
        inputValidator = new AuthInputValidator();
        dbProcessor = new DBProcessor((Connection) getServletContext().getAttribute("dbConnection"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (inputValidator.validate(username, password)) {
            if (dbProcessor.containsUser(username)) {
                if (dbProcessor.authUser(username, password)) {
                    User user = dbProcessor.getUserByUsername(username);
                    req.getSession().setAttribute("userId", user.getId());
                    req.getSession().setAttribute("name", user.getUsername());
                    req.getSession().setAttribute("role", user.getRole());
                    resp.sendRedirect(getServletContext().getContextPath() +  "/profile");
                } else {
                    String errorText = "incorrect password";
                    req.setAttribute("errorText", errorText);
                    getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
                }
            } else {
                String errorText = username + " " + "not found";
                req.setAttribute("errorText", errorText);
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
            }
        } else {
            String errorText = inputValidator.getMessage();
            req.setAttribute("errorText", errorText);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
        }
    }
}

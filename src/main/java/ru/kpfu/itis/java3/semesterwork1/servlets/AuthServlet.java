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
        dbProcessor = (DBProcessor) getServletContext().getAttribute("dbProcessor");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO encapsulate
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(!inputValidator.validate(username, password)) {
            req.setAttribute("errorText", inputValidator.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
            return;
        }
        if (!dbProcessor.containsUser(username)) {
            req.setAttribute("errorText", username + " not found");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
            return;
        }
        if (!dbProcessor.authUser(username, password)) {
            req.setAttribute("errorText", "incorrect password");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
            return;
        }
        User user = dbProcessor.getUserByUsername(username);
        req.getSession().setAttribute("userId", user.getId());
        req.getSession().setAttribute("name", user.getUsername());
        req.getSession().setAttribute("role", user.getRole());
        resp.sendRedirect(getServletContext().getContextPath() +  "/profile");
    }
}

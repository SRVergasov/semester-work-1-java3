package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.dao.UserDao;
import ru.kpfu.itis.java3.semesterwork1.db.DBProcessor;
import ru.kpfu.itis.java3.semesterwork1.entity.User;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;
import ru.kpfu.itis.java3.semesterwork1.validators.AuthInputValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
    private AuthInputValidator inputValidator;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        inputValidator = new AuthInputValidator();
        userDao = (UserDao) getServletContext().getAttribute("userDao");
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
        try {
            if (!userDao.containsUser(username)) {
                req.setAttribute("errorText", username + " not found");
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
                return;
            }
            if (!userDao.authUser(username, password)) {
                req.setAttribute("errorText", "incorrect password");
                getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
                return;
            }
            User user = userDao.getUserByUsername(username);
            req.getSession().setAttribute("userId", user.getId());
            req.getSession().setAttribute("name", user.getUsername());
            req.getSession().setAttribute("role", user.getRole());
            resp.sendRedirect(getServletContext().getContextPath() +  "/profile");
        } catch (DBException e) {
            req.setAttribute("errorText", e.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
        }
    }
}

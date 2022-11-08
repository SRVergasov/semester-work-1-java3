package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.dao.UserDao;
import ru.kpfu.itis.java3.semesterwork1.db.DBProcessor;
import ru.kpfu.itis.java3.semesterwork1.entity.User;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/panel")
public class AdminPanelServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Panel");
        try {
            req.setAttribute("userList", userDao.getUsersList());
        } catch (DBException e) {
            req.setAttribute("errorText", e.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminPanel.jsp").forward(req, resp);
    }
}

package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.db.DBProcessor;
import ru.kpfu.itis.java3.semesterwork1.entity.User;
import ru.kpfu.itis.java3.semesterwork1.validators.RatingInputValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/panel/edit")
public class AdminPanelEditServlet extends HttpServlet {
    private DBProcessor dbProcessor;
    private RatingInputValidator validator;

    @Override
    public void init() throws ServletException {
        dbProcessor = new DBProcessor((Connection) getServletContext().getAttribute("dbConnection"));
        validator = new RatingInputValidator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = dbProcessor.getUserById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("title", "Panel editing");
        req.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/adminPanelEdit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newRating = req.getParameter("newRating");
        if (validator.validate(newRating)) {
            dbProcessor.setRating(Integer.parseInt(req.getParameter("id")), Integer.parseInt(newRating));
            resp.sendRedirect(getServletContext().getContextPath() + "/panel");
        } else {
            String errorText = validator.getMessage();
            req.setAttribute("errorText", errorText);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
        }
    }
}

package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.db.DBProcessor;
import ru.kpfu.itis.java3.semesterwork1.validators.AddQuestionInputValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/questions/add_question")
public class QuestionAddServlet extends HttpServlet {
    private DBProcessor dbProcessor;
    private AddQuestionInputValidator inputValidator;

    @Override
    public void init() throws ServletException {
        dbProcessor = new DBProcessor((Connection) getServletContext().getAttribute("dbConnection"));
        inputValidator = new AddQuestionInputValidator();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        int userId = (int) req.getSession().getAttribute("userId");
        if (!inputValidator.validate(title, description)) {
            req.setAttribute("errorText", inputValidator.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
            return;
        }
        dbProcessor.addQuestion(userId, title, description);
        resp.sendRedirect(getServletContext().getContextPath() + "/questions/list");
    }
}

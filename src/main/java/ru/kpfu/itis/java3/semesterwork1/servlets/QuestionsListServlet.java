package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.dao.QuestionDao;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questions")
public class QuestionsListServlet extends HttpServlet {
    private QuestionDao questionDao;

    @Override
    public void init() throws ServletException {
        questionDao = (QuestionDao) getServletContext().getAttribute("questionDao");    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Questions list");
        try {
            req.setAttribute("questionsList", questionDao.getQuestionsList());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/questionsList.jsp").forward(req, resp);
        } catch (DBException e) {
            req.setAttribute("errorText", e.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
        }
    }
}

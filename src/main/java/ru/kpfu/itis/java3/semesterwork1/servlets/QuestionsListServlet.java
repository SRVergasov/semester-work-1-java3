package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.db.DBProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/questions/list")
public class QuestionsListServlet extends HttpServlet {
    private DBProcessor dbProcessor;

    @Override
    public void init() throws ServletException {
        dbProcessor = (DBProcessor) getServletContext().getAttribute("dbProcessor");    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Questions list");
        req.setAttribute("questionsList", dbProcessor.getQuestionsList());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/questionsList.jsp").forward(req, resp);
    }
}

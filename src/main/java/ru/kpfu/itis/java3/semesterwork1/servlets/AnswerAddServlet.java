package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.db.DBProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/questions/add_answer")
public class AnswerAddServlet extends HttpServlet {
    private DBProcessor dbProcessor;

    @Override
    public void init() throws ServletException {
        dbProcessor = (DBProcessor) getServletContext().getAttribute("dbProcessor");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int questionId = Integer.parseInt(req.getParameter("questionId"));
        int userId = Integer.parseInt(req.getParameter("userId"));
        String text = req.getParameter("text");
        if (text.isEmpty()) {
            req.setAttribute("errorText", "Empty text field");
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
            return;
        }
        dbProcessor.addAnswer(questionId, userId, text);
        resp.sendRedirect(getServletContext().getContextPath() + "/questions/question?id=" + questionId);
    }
}

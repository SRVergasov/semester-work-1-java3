package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.db.DBProcessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questions/add_like")
public class LikeAddServlet extends HttpServlet {
    private DBProcessor dbProcessor;

    @Override
    public void init() throws ServletException {
        dbProcessor = (DBProcessor) getServletContext().getAttribute("dbProcessor");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userId = (int) req.getSession().getAttribute("userId");
        int answerId = Integer.parseInt(req.getParameter("answerId"));
        int questionId = Integer.parseInt(req.getParameter("questionId"));
        int authorId = dbProcessor.getAnswerById(answerId).getUserId();
        if (dbProcessor.like(userId, answerId)) {
            dbProcessor.updateRating(authorId, 1);
        } else {
            dbProcessor.updateRating(authorId, -1);
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/questions/question?id=" + questionId);

    }
}

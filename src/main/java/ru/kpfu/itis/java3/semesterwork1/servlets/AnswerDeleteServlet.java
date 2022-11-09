package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.dao.AnswerDao;
import ru.kpfu.itis.java3.semesterwork1.dao.UserDao;
import ru.kpfu.itis.java3.semesterwork1.entity.Answer;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questions/answer_delete")
public class AnswerDeleteServlet extends HttpServlet {
    private AnswerDao answerDao;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        answerDao = (AnswerDao) getServletContext().getAttribute("answerDao");
        userDao = (UserDao) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int answerId = Integer.parseInt(req.getParameter("answerId"));
        try {
            Answer answer = answerDao.getAnswerById(answerId);
            int likesCount = answerDao.getAnswerLikesCount(answerId);
            answerDao.deleteAnswer(answerId);
            userDao.updateRating(answer.getUserId(), -likesCount);
            resp.sendRedirect(getServletContext().getContextPath() + "/questions/question?id=" + answer.getQuestion());
        } catch (DBException e) {
            req.setAttribute("errorText", e.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
        }
    }
}

package ru.kpfu.itis.java3.semesterwork1.servlets.helpers;

import ru.kpfu.itis.java3.semesterwork1.dao.AnswerDao;
import ru.kpfu.itis.java3.semesterwork1.dao.UserDao;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questions/add_like")
public class LikeSetServlet extends HttpServlet {
    private AnswerDao answerDao;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        answerDao = (AnswerDao) getServletContext().getAttribute("answerDao");
        userDao = (UserDao) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userId = (int) req.getSession().getAttribute("userId");
        int answerId = Integer.parseInt(req.getParameter("answerId"));
        int questionId = Integer.parseInt(req.getParameter("questionId"));
        try {
            int authorId = answerDao.getAnswerById(answerId).getUserId();
            if (answerDao.like(userId, answerId)) {
                userDao.updateRating(authorId, 1);
            } else {
                userDao.updateRating(authorId, -1);
            }
            resp.sendRedirect(getServletContext().getContextPath() + "/questions/question?id=" + questionId);
        } catch (DBException e) {
            req.setAttribute("errorText", e.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
        }

    }
}

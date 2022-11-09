package ru.kpfu.itis.java3.semesterwork1.servlets.helpers;

import ru.kpfu.itis.java3.semesterwork1.dao.AnswerDao;
import ru.kpfu.itis.java3.semesterwork1.dao.QuestionDao;
import ru.kpfu.itis.java3.semesterwork1.dao.UserDao;
import ru.kpfu.itis.java3.semesterwork1.entity.Answer;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/questions/question_delete")
public class QuestionDeleteServlet extends HttpServlet {
    private UserDao userDao;
    private QuestionDao questionDao;
    private AnswerDao answerDao;

    @Override
    public void init() throws ServletException {
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        questionDao = (QuestionDao) getServletContext().getAttribute("questionDao");
        answerDao = (AnswerDao) getServletContext().getAttribute("answerDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int questionId = Integer.parseInt(req.getParameter("questionId"));
        try {
            for (Answer answer : answerDao.getAnswersList(questionId)) {
                int likesCount = answerDao.getAnswerLikesCount(answer.getId());
                answerDao.deleteAnswer(answer.getId());
                userDao.updateRating(answer.getUserId(), -likesCount);
            }
            questionDao.deleteQuestion(questionId);
            resp.sendRedirect(getServletContext().getContextPath() + "/questions");
        } catch (DBException e) {
            req.setAttribute("errorText", e.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
        }
    }
}

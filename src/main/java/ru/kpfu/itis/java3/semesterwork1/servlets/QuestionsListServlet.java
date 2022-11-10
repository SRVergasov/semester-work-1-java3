package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.dao.QuestionDao;
import ru.kpfu.itis.java3.semesterwork1.dao.UserDao;
import ru.kpfu.itis.java3.semesterwork1.entity.Question;
import ru.kpfu.itis.java3.semesterwork1.exceptions.DBException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/questions")
public class QuestionsListServlet extends HttpServlet {
    private QuestionDao questionDao;
    private UserDao userDao;

    @Override
    public void init() throws ServletException {
        questionDao = (QuestionDao) getServletContext().getAttribute("questionDao");
        userDao = (UserDao) getServletContext().getAttribute("userDao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Questions list");
        try {
            List<Question> questionList = questionDao.getQuestionsList();
            List<String> usernames = new ArrayList<>();
            for (Question q : questionList) {
                usernames.add(userDao.getUserById(q.getUserId()).getUsername());
            }
            req.setAttribute("questionsList", questionList);
            req.setAttribute("usernames", usernames);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/questionsList.jsp").forward(req, resp);
        } catch (DBException e) {
            req.setAttribute("errorText", e.getMessage());
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, resp);
        }
    }
}

package ru.kpfu.itis.java3.semesterwork1.servlets;

import ru.kpfu.itis.java3.semesterwork1.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Profile");
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("user", user);
        req.setAttribute("name", user.getUsername());
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/profile.jsp").forward(req, resp);
    }
}

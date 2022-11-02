package ru.kpfu.itis.java3.semesterwork1.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/profile")
public class SecurityFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpSession session = req.getSession();
        if (session.getAttribute("user") == null) {
            String errorText = "Not access to not guests (please authorize)";
            req.setAttribute("errorText", errorText);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/errorPage.jsp").forward(req, res);
            return;
        }

        chain.doFilter(req, res);
    }
}

package org.example.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class HomeServet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String page = req.getParameter("page");
        if (page != null) {
            resp.getWriter().println("Welcome to BMR's website");
            return;
        }
        String des = "/WEB-INF/jsp" + page + ".jsp";
        req.getRequestDispatcher(des).forward(req, resp);
    }


}

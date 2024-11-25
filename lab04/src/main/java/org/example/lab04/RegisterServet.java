package org.example.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@WebServlet("/register")
public class RegisterServet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("register");
    }

    @Override
    public void destroy() {
        System.out.println("deleting");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        String birthtime = request.getParameter("birthtime");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] ides = request.getParameterValues("ide");
        int toeic = Integer.parseInt(request.getParameter("toeic"));
        String description = request.getParameter("description");

        if (name == null || email == null || birthday == null || birthtime == null || gender == null || country == null || ides == null || description == null) {
            response.getWriter().println("Please fill in all fields.");
            return;
        }

        List<String> ideList = new ArrayList<>();
        for (String ide : ides) {
            ideList.add(ide);
        }

        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("birthday", birthday);
        request.setAttribute("birthtime", birthtime);
        request.setAttribute("gender", gender);
        request.setAttribute("country", country);
        request.setAttribute("ides", ideList);
        request.setAttribute("toeic", toeic);
        request.setAttribute("description", description);

        request.getRequestDispatcher("/WEB-INF/jsp/showInfo.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
    }
}
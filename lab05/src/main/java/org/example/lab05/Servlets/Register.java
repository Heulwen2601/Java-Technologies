package org.example.lab05.Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.lab05.DAO.UserDAO;
import org.example.lab05.Models.User;

import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        try{
            User user = new User(username,email,password);
            userDAO.add(user);
            resp.sendRedirect("/Lab05_war_exploded/Login");
        }
        catch (Exception e){
            System.out.println("Failed to register!!");
            System.out.println(e.getMessage());
            resp.sendRedirect("/Lab05_war_exploded/register");
        }
    }
}

package org.example.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class LoginServet extends HttpServlet {

    private HashMap<String, String> ListUsers;

    @Override
    public void init() throws ServletException {
        ListUsers = new HashMap<>();
        ListUsers.put("admin", "admin");
        ListUsers.put("user", "user");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        if(ListUsers.containsKey(username) && ListUsers.get(username).equals(password)) {
            out.println("Login Successful");
        }
        else {
            out.println("Login Failed");
        }
        out.close();
    }
}

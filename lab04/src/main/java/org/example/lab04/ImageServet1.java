package org.example.lab04;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/image1")
public class ImageServet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("image/png");

        try (FileInputStream fin = new FileInputStream(req.getServletContext().getRealPath("/WEB-INF/images/cat.png"));
             BufferedInputStream bis = new BufferedInputStream(fin);
             BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream())) {

            int check;
            while ((check = bis.read()) != -1) {
                bos.write(check);
            }
        }
    }
}

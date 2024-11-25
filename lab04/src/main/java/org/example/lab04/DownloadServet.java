package org.example.lab04;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class DownloadServet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String filename = req.getParameter("filename");
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");

        if(filename == null) {
            resp.getWriter().println("No file found");
        }
        try (InputStream in = req.getServletContext().getResourceAsStream("/WEB-INF/files/" + filename)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                resp.getOutputStream().write(buffer, 0, length);
            }
        }
    }
}

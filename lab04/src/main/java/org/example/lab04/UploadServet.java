package org.example.lab04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.http.Part;
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.RequestContext;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadServet extends HttpServlet {
    private final String UPLOAD_DIRECTORY = "WEB-INF/uploads";

    private final String[] EXTENSION_LIST = {"txt", "pdf", "rar", "doc", "docx", "img", "zip"};
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("file") != null) {
            String fileName = request.getParameter("file");
            String filePath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY + fileName;

            File downloadFile = new File(filePath);
            FileInputStream inputStream = new FileInputStream(downloadFile);
            String extension = FilenameUtils.getExtension(fileName);
            String contentType = getContentType(extension);
            response.setContentType(contentType);
            response.setContentLengthLong(downloadFile.length());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            OutputStream outputStream = response.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            inputStream.close();
            outputStream.close();
        }
        else {
            request.getRequestDispatcher("/WEB-INF/jsp/upload.jsp").forward(request, response);
        }

    }
    private String getContentType(String extension) {
        switch (extension.toLowerCase()) {
            case "txt":
                return "text/plain";
            case "pdf":
                return "application/pdf";
            case "rar":
                return "application/x-rar-compressed";
            case "doc":
            case "docx":
                return "application/msword";
            case "img":
                return "image/jpeg";
            case "zip":
                return "application/zip";
            default:
                return "application/octet-stream";
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        String fileName = request.getParameter("fileName");
        Part filePart = request.getPart("File");
        String overwriteParam = request.getParameter("overwrite");
        boolean overwrite = overwriteParam != null && overwriteParam.equalsIgnoreCase("YES");

        String submittedFileName = filePart.getSubmittedFileName();
        String extension = submittedFileName.substring(submittedFileName.lastIndexOf(".") + 1);
        if (!isValidExtension(extension)) {
            request.setAttribute("message", "Unsupported file extension!");
            request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);
            return;
        }

        File uploadFile = new File(uploadDir, fileName);
        if (uploadFile.exists() && !overwrite) {

            request.setAttribute("message", "File already exists!"+ uploadDir);
            request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);
            return;
        }

        String relativeUploadPath = "WEB-INF/uploads/" + fileName;
        String absoluteUploadPath = getServletContext().getRealPath("") + File.separator + relativeUploadPath;

        filePart.write(absoluteUploadPath);

        String downloadUrl = request.getContextPath() + "/download?file=" + fileName;
        request.setAttribute("message", "File uploaded. Click <a href='" + downloadUrl + "'>here</a> to visit file.");
        request.getRequestDispatcher("/WEB-INF/jsp/result.jsp").forward(request, response);

    }

    private boolean isValidExtension(String extension) {
        String[] validExtensions = {"txt", "doc", "docx", "img", "pdf", "rar", "zip"};
        for (String validExtension : validExtensions) {
            if (validExtension.equalsIgnoreCase(extension)) {
                return true;
            }
        }
        return false;
    }

}

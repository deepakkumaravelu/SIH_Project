package com.sih.servlets;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/UploadFileServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) // Max file size: 10MB
public class UploadFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbURL = "jdbc:mysql://localhost:3306/sih";
        String dbUser = "root";
        String dbPassword = "8066408066";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            // Get the file part from the request
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();

            // Get the input stream of the uploaded file
            InputStream fileInputStream = filePart.getInputStream();
            HttpSession session=request.getSession(true); 
            String username=(String)session.getAttribute("username");  
            // Prepare the SQL insert statement
            String sql = "INSERT INTO uploaded_files (file_name,file_data,username) VALUES (?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, fileName);
            statement.setBinaryStream(2, fileInputStream, (int) filePart.getSize());
            statement.setString(3, username);
            // Execute the insert statement
            statement.executeUpdate();

            response.setContentType("text/html");
            response.getWriter().write("<script>alert('File uploaded successfully!');</script>"); 
            response.sendRedirect("search.html");// Redirect to a success page
          
        } catch (SQLException ex) {
            throw new ServletException("Database Connection Error", ex);
        }
    }
}

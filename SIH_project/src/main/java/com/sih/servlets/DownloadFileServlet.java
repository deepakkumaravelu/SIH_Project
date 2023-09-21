package com.sih.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadFileServlet")
public class DownloadFileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbURL = "jdbc:mysql://localhost:3306/sih";
        String dbUser = "root";
        String dbPassword = "8066408066";

        String fileName = request.getParameter("fileName");

        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            // Retrieve the file data from the database
            String sql = "SELECT file_data FROM uploaded_files WHERE file_name = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, fileName);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Blob blob = resultSet.getBlob("file_data");

                // Set the response headers for file download
                response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

                // Get the output stream and write the file data to the response
                try (InputStream inputStream = blob.getBinaryStream();
                     OutputStream outputStream = response.getOutputStream()) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        } catch (SQLException ex) {
            throw new ServletException("Database Connection Error", ex);
        }
    }
}

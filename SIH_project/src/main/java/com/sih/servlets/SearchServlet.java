package com.sih.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dbURL = "jdbc:mysql://localhost:3306/sih";
        String dbUser = "root";
        String dbPassword = "8066408066";

        String searchKeyword = request.getParameter("searchKeyword");
        List<String> searchResults = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            // Perform a flexible search based on the search keyword
            String sql = "SELECT file_name FROM uploaded_files WHERE " +
                         "file_name LIKE ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            String keywordPattern = "%" + searchKeyword + "%";
            statement.setString(1, keywordPattern);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                searchResults.add(resultSet.getString("file_name"));
            }
        } catch (SQLException ex) {
            throw new ServletException("Database Connection Error", ex);
        }

        // Set the search results as an attribute in the request
        request.setAttribute("searchResults", searchResults);

        // Forward the request and response to the search.jsp page
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}

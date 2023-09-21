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
import javax.servlet.http.HttpSession;

// Import statements...

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        String username = (String) session.getAttribute("username");

        if (username != null) {
            // Database connection parameters
            String jdbcUrl = "jdbc:mysql://localhost:3306/sih";
            String dbUsername = "root";
            String dbPassword = "8066408066";

            Connection conn = null;
            PreparedStatement stmtUser = null;
            PreparedStatement stmtFiles = null;
            ResultSet rsUser = null;
            ResultSet rsFiles = null;

            try {
                // Establish a database connection
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);

                // SQL query to retrieve user details based on the username
                String sqlUser = "SELECT * FROM regdetails WHERE username = ?";
                stmtUser = conn.prepareStatement(sqlUser);
                stmtUser.setString(1, username);
                rsUser = stmtUser.executeQuery();

                if (rsUser.next()) {
                    String userName = rsUser.getString("name");
                    String clgregno = rsUser.getString("clgregno");
                    String org = rsUser.getString("org");
                    String clgmail = rsUser.getString("clgmail");
                    String pmail = rsUser.getString("pmail");
                    String gender = rsUser.getString("gender");
                    String dob = rsUser.getString("dob");
                    String hqualification = rsUser.getString("hqualification");
                    String yOG = rsUser.getString("yOG");
                    String pincode = rsUser.getString("pincode");
                    String state = rsUser.getString("state");
                    String district = rsUser.getString("district");
                    String currentyear = rsUser.getString("currentyear");
                    String dep = rsUser.getString("dep");
                    String degree = rsUser.getString("degree");

                    // SQL query to retrieve file names uploaded by the user
                    String sqlFiles = "SELECT file_name FROM uploaded_files WHERE username = ?";
                    stmtFiles = conn.prepareStatement(sqlFiles);
                    stmtFiles.setString(1, username);
                    rsFiles = stmtFiles.executeQuery();

                    List<String> fileNames = new ArrayList<>();
                    while (rsFiles.next()) {
                        String fileName = rsFiles.getString("file_name");
                        fileNames.add(fileName);
                    }

                    // Store user details and file names in request attributes
                    request.setAttribute("userName", userName);
                    request.setAttribute("clgregno", clgregno);
                    request.setAttribute("org", org);
                    request.setAttribute("clgmail", clgmail);
                    request.setAttribute("pmail", pmail);
                    request.setAttribute("gender", gender);
                    request.setAttribute("dob", dob);
                    request.setAttribute("hqualification", hqualification);
                    request.setAttribute("yOG", yOG);
                    request.setAttribute("pincode", pincode);
                    request.setAttribute("state", state);
                    request.setAttribute("district", district);
                    request.setAttribute("currentyear", currentyear);
                    request.setAttribute("dep", dep);
                    request.setAttribute("degree", degree);
                    request.setAttribute("fileNames", fileNames);

                    // Forward the request to the JSP file
                    request.getRequestDispatcher("/user_profile.jsp").forward(request, response);
                } else {
                    response.getWriter().println("User not found.");
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (rsUser != null) {
                        rsUser.close();
                    }
                    if (rsFiles != null) {
                        rsFiles.close();
                    }
                    if (stmtUser != null) {
                        stmtUser.close();
                    }
                    if (stmtFiles != null) {
                        stmtFiles.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            response.getWriter().println("User session not found.");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}

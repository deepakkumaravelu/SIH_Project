package com.sih.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sih.bean.Registration;
import com.sih.dao.SignupDao;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name=request.getParameter("name");
			String username = request.getParameter("username");
			String clgregno = request.getParameter("collegeregno");
			String org = request.getParameter("organization");
			String clgmail = request.getParameter("collegeemail");
			String pmail = request.getParameter("personalemail");
			String gender= request.getParameter("sex");
			String dob = request.getParameter("dob");
			String hqualification= request.getParameter("highestqualification");
			String yOG = request.getParameter("yearofgraduation");
			String pincode = request.getParameter("pincode");
			String state = request.getParameter("state");
			String district = request.getParameter("district");
			String currentyear = request.getParameter("currentyear");
			String dep = request.getParameter("department");
			String degree = request.getParameter("degree");
			String password = request.getParameter("password");

			Registration user = new Registration(name,username,clgregno,org,clgmail,pmail,gender,dob,hqualification,yOG,pincode,state,district,currentyear,dep,degree,password);
			SignupDao.insertData(user);
			response.sendRedirect("login.html");
		} catch (Exception e) {
			response.getWriter().println("Error: " + e.getMessage());
		}
		
	}

}


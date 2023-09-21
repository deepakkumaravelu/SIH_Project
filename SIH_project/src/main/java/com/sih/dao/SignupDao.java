package com.sih.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sih.bean.Registration;
import com.sih.util.DButil;


public class SignupDao {
	public static void insertData(Registration user) {
		try {
			Connection con = DButil.getConnection();
			PreparedStatement pstmt = con.prepareStatement("insert into regdetails (name, username, clgregno, org, clgmail, pmail, gender, dob, hqualification, yOG, pincode, state, district, currentyear, dep, degree, password"
					+ ") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getUsername());
			pstmt.setString(3,user.getClgregno());
			pstmt.setString(4, user.getOrg());
			pstmt.setString(5, user.getClgmail());
			pstmt.setString(6, user.getPmail());
			pstmt.setString(7, user.getGender());
			pstmt.setString(8, user.getDob());
			pstmt.setString(9, user.getHqualification());
			pstmt.setString(10, user.getyOG());
			pstmt.setString(11, user.getPincode());
			pstmt.setString(12, user.getState());
			pstmt.setString(13, user.getDistrict());
			pstmt.setString(14, user.getCurrentyear());
			pstmt.setString(15, user.getDep());
			pstmt.setString(16, user.getDegree());
			pstmt.setString(17, user.getPassword());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
}
}

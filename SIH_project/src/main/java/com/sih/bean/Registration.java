package com.sih.bean;

public class Registration {

	private String name;
	private String username; private String clgregno; private String org; private String clgmail;private  String pmail;private 
	String gender;private  String dob; String hqualification;private  String yOG;private  String pincode;private  String state;private  String district;
	String currentyear;private  String dep;private  String degree;private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClgregno() {
		return clgregno;
	}

	public void setClgregno(String clgregno) {
		this.clgregno = clgregno;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getClgmail() {
		return clgmail;
	}

	public void setClgmail(String clgmail) {
		this.clgmail = clgmail;
	}

	public String getPmail() {
		return pmail;
	}

	public void setPmail(String pmail) {
		this.pmail = pmail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getHqualification() {
		return hqualification;
	}

	public void setHqualification(String hqualification) {
		this.hqualification = hqualification;
	}

	public String getyOG() {
		return yOG;
	}

	public void setyOG(String yOG) {
		this.yOG = yOG;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCurrentyear() {
		return currentyear;
	}

	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Registration(String name, String username, String clgregno, String org, String clgmail, String pmail,
			String gender, String dob, String hqualification, String yOG, String pincode, String state, String district,
			String currentyear, String dep, String degree, String password) {
		super();
		this.name = name;
		this.username = username;
		this.clgregno = clgregno;
		this.org = org;
		this.clgmail = clgmail;
		this.pmail = pmail;
		this.gender = gender;
		this.dob = dob;
		this.hqualification = hqualification;
		this.yOG = yOG;
		this.pincode = pincode;
		this.state = state;
		this.district = district;
		this.currentyear = currentyear;
		this.dep = dep;
		this.degree = degree;
		this.password = password;
	}

	public Registration() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Registration [name=" + name + ", username=" + username + ", clgregno=" + clgregno + ", org=" + org
				+ ", clgmail=" + clgmail + ", pmail=" + pmail + ", gender=" + gender + ", dob=" + dob
				+ ", hqualification=" + hqualification + ", yOG=" + yOG + ", pincode=" + pincode + ", state=" + state
				+ ", district=" + district + ", currentyear=" + currentyear + ", dep=" + dep + ", degree=" + degree
				+ ", password=" + password + "]";
	}

}

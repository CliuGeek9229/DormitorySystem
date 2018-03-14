package com.example.dormitorysystem.entity;

public class user {
	private String stuID;
	private String stuPW;
	private String realname;
	private String sex;
	private String school;
	private String major;
	private int apartment;
	private int dormitory;
	
	public user(){
		
	}
	
	
	
	
	
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getApartment() {
		return apartment;
	}
	public void setApartment(int apartment) {
		this.apartment = apartment;
	}
	public int getDormitory() {
		return dormitory;
	}
	public void setDormitory(int dormitory) {
		this.dormitory = dormitory;
	}





	public String getStuID() {
		return stuID;
	}





	public void setStuID(String stuID) {
		this.stuID = stuID;
	}





	public String getStuPW() {
		return stuPW;
	}





	public void setStuPW(String stuPW) {
		this.stuPW = stuPW;
	}

}

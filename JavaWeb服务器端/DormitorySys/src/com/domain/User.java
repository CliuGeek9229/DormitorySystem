package com.domain;

public class User {

	public User(){
		
	}
	@Override
	public String toString() {
		return "User [stuID=" + stuID + ", stuPW=" + stuPW + ", realname=" + realname + ", sex=" + sex + ", school="
				+ school + ", major=" + major + ", apartment=" + apartment + ", dormitory=" + dormitory + "]";
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
	public User(String stuID, String stuPW, String realname, String sex, String school, String major, int apartment,
			int dormitory) {
		super();
		this.stuID = stuID;
		this.stuPW = stuPW;
		this.realname = realname;
		this.sex = sex;
		this.school = school;
		this.major = major;
		this.apartment = apartment;
		this.dormitory = dormitory;
	}
	//用户信息
	private String stuID;
	private String stuPW;
	private String realname;
	private String sex;
	private String school;
	private String major;
	private int apartment;
	private int dormitory;

}

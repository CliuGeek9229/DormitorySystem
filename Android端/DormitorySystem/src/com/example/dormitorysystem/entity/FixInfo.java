package com.example.dormitorysystem.entity;

public class FixInfo {
	private String stuID;
	private String realname;
	private String school;
	private int Apartment;
	private int Dormitory;
	private String detail;
	
	public FixInfo(String stuID, String realname, String school, int apartment,
			int dormitory, String detail) {
		super();
		this.stuID = stuID;
		this.realname = realname;
		this.school = school;
		Apartment = apartment;
		Dormitory = dormitory;
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "FixInfo [stuID=" + stuID + ", realname=" + realname
				+ ", school=" + school + ", Apartment=" + Apartment
				+ ", Dormitory=" + Dormitory + ", detail=" + detail + "]";
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getApartment() {
		return Apartment;
	}
	public void setApartment(int apartment) {
		Apartment = apartment;
	}
	public int getDormitory() {
		return Dormitory;
	}
	public void setDormitory(int dormitory) {
		Dormitory = dormitory;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public FixInfo() {
		// TODO Auto-generated constructor stub
	}

}

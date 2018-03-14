package com.domain;

public class LateInfo {
	private String stuID;
	private String realname;
	private int apartment;
	private int dormitory;
	private String school;
	public LateInfo(String stuID, String realname, int apartment,
			int dormitory, String school) {
		super();
		this.stuID = stuID;
		this.realname = realname;
		this.apartment = apartment;
		this.dormitory = dormitory;
		this.school = school;
	}
	@Override
	public String toString() {
		return "LateInfo [stuID=" + stuID + ", realname=" + realname
				+ ", apartment=" + apartment + ", dormitory=" + dormitory
				+ ", school=" + school + "]";
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public LateInfo() {
		// TODO Auto-generated constructor stub
	}

}

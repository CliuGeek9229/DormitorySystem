package com.example.dormitorysystem.entity;

public class StayInfo {
	private String stuID;
	private String realname;
	private int apartment;
	private int dormitory;
	private String detail;
	public StayInfo(String stuID, String realname, int apartment,
			int dormitory, String detail) {
		super();
		this.stuID = stuID;
		this.realname = realname;
		this.apartment = apartment;
		this.dormitory = dormitory;
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "StayInfo [stuID=" + stuID + ", realname=" + realname
				+ ", apartment=" + apartment + ", dormitory=" + dormitory
				+ ", detail=" + detail + "]";
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public StayInfo() {
		// TODO Auto-generated constructor stub
	}

}

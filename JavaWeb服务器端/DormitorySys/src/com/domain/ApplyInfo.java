package com.domain;

public class ApplyInfo {
	private String stuID;
	private String realname;
	private String school;
	private int apartment;
	private int dormitory;
	private int targetApart;
	private int targetRoom;
	private String reason;
	
	
	
	public ApplyInfo(String stuID, String realname, String school,
			int apartment, int dormitory, int targetApart, int targetRoom,
			String reason) {
		super();
		this.stuID = stuID;
		this.realname = realname;
		this.school = school;
		this.apartment = apartment;
		this.dormitory = dormitory;
		this.targetApart = targetApart;
		this.targetRoom = targetRoom;
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "ApplyInfo [stuID=" + stuID + ", realname=" + realname
				+ ", school=" + school + ", apartment=" + apartment
				+ ", dormitory=" + dormitory + ", targetApart=" + targetApart
				+ ", targetRoom=" + targetRoom + ", reason=" + reason + "]";
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

	public int getTargetApart() {
		return targetApart;
	}

	public void setTargetApart(int targetApart) {
		this.targetApart = targetApart;
	}

	public int getTargetRoom() {
		return targetRoom;
	}

	public void setTargetRoom(int targetRoom) {
		this.targetRoom = targetRoom;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public ApplyInfo() {
		// TODO Auto-generated constructor stub
	}

}

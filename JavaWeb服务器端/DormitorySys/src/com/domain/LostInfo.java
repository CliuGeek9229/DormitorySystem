package com.domain;

public class LostInfo {
	private String stuID;
	private String realname;
	private String detail;
	
	public LostInfo(String stuID, String realname, String detail) {
		super();
		this.stuID = stuID;
		this.realname = realname;
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "LostInfo [stuID=" + stuID + ", realname=" + realname
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public LostInfo() {
		// TODO Auto-generated constructor stub
	}

}

package com.example.dormitorysystem.app;

import android.app.Application;

public class MyApplication extends Application {
	
	private int Pagenum;
	
	private String stuID;
	private String stuPW;
	private String realname;
	private String sex;
	private String school;
	private String major;
	private int apartment;
	private int dormitory;
	
	
	
	private String Announce;
	
	private String tradeInfo;
	
	private String RoomForExange;
	
	private String LostInfo;
	
	private String MyFixInfo;
	
	private String MyExchangeInfo;
	
	private String MyStayInfo;
	
	private String MyLostInfo;
	
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
	
	public int getPagenum() {
		return Pagenum;
	}
	public void setPagenum(int pagenum) {
		this.Pagenum = pagenum;
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

	public String getAnnounce() {
		return Announce;
	}

	public void setAnnounce(String announce) {
		Announce = announce;
	}

	public String getTradeInfo() {
		return tradeInfo;
	}

	public void setTradeInfo(String tradeInfo) {
		this.tradeInfo = tradeInfo;
	}

	public String getRoomForExange() {
		return RoomForExange;
	}

	public void setRoomForExange(String roomForExange) {
		RoomForExange = roomForExange;
	}

	public String getLostInfo() {
		return LostInfo;
	}

	public void setLostInfo(String lostInfo) {
		LostInfo = lostInfo;
	}

	public String getMyFixInfo() {
		return MyFixInfo;
	}

	public void setMyFixInfo(String myFixInfo) {
		MyFixInfo = myFixInfo;
	}

	public String getMyExchangeInfo() {
		return MyExchangeInfo;
	}

	public void setMyExchangeInfo(String myExchangeInfo) {
		MyExchangeInfo = myExchangeInfo;
	}

	public String getMyStayInfo() {
		return MyStayInfo;
	}

	public void setMyStayInfo(String myStayInfo) {
		MyStayInfo = myStayInfo;
	}

	public String getMyLostInfo() {
		return MyLostInfo;
	}

	public void setMyLostInfo(String myLostInfo) {
		MyLostInfo = myLostInfo;
	}
	
}

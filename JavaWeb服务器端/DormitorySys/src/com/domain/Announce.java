package com.domain;

import java.sql.Timestamp;

public class Announce {
	private String details;
	private int id;
	private Timestamp announceTime;
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getAnnounceTime() {
		return announceTime;
	}
	public void setAnnounceTime(Timestamp announceTime) {
		this.announceTime = announceTime;
	}
	public Announce(){
		
	}
	public Announce(String details, int id, Timestamp announceTime) {
		super();
		this.details = details;
		this.id = id;
		this.announceTime = announceTime;
	}
	@Override
	public String toString() {
		return "Announce [details=" + details + ", id=" + id + ", announceTime=" + announceTime + "]";
	}

}

package com.domain;

import java.sql.Timestamp;

public class Oldthing {
	private String details;
	private int id;
	private Timestamp announceTime;

	public Oldthing(String details, int id, Timestamp announceTime) {
		super();
		this.details = details;
		this.id = id;
		this.announceTime = announceTime;
	}

	@Override
	public String toString() {
		return "Oldthing [details=" + details + ", id=" + id + ", announceTime=" + announceTime + "]";
	}

	public Oldthing() {
		// TODO Auto-generated constructor stub
	}

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

}

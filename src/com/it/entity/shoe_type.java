package com.it.entity;

public class shoe_type {
	private int sttypeid;
	public int getSttypeid() {
		return sttypeid;
	}
	public void setSttypeid(int sttypeid) {
		this.sttypeid = sttypeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	public shoe_type(int sttypeid, String name) {
		super();
		this.sttypeid = sttypeid;
		this.name = name;
	}
	public shoe_type() {
		super();
	}	
}

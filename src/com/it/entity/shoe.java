package com.it.entity;

public class shoe {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getMoods() {
		return moods;
	}
	public void setMoods(int moods) {
		this.moods = moods;
	}
	public int getTtypeid() {
		return ttypeid;
	}
	public void setTtypeid(int ttypeid) {
		this.ttypeid = ttypeid;
	}
	public int getSsid() {
		return ssid;
	}
	public void setSsid(int ssid) {
		this.ssid = ssid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	private double price;
	private int number;
	private int moods;
	private int ttypeid;
	private int ssid;
	private String path;
	public shoe(String name, double price, int number, int moods, int ttypeid,
			int ssid, String path) {
		super();
		this.name = name;
		this.price = price;
		this.number = number;
		this.moods = moods;
		this.ttypeid = ttypeid;
		this.ssid = ssid;
		this.path = path;
	}
	public shoe() {
		super();
	}
	
}

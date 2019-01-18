package com.fuber.cabbooking.model;

public class Location {

	private double latitude;
	private double longitude;
	public Location(String latitude2, String longitude2) {
		this.latitude = new Double(latitude2);
		this.longitude = new Double(longitude2);
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}

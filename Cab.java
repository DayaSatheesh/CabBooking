package com.fuber.cabbooking.model;

import java.sql.Timestamp;

public class Cab {
	private String colour;
	private boolean isAvailable;
	private String cabNumber;
	private Location cabLocation;
	private Timestamp arrival;
	private Timestamp started;
	private Timestamp tripCompleted;
	
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String getCabNumber() {
		return cabNumber;
	}
	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}
	public Location getCabLocation() {
		return cabLocation;
	}
	public void setCabLocation(Location cabLocation) {
		this.cabLocation = cabLocation;
	}
	public Timestamp getArrival() {
		return arrival;
	}
	public void setArrival(Timestamp arrival) {
		this.arrival = arrival;
	}
	public Timestamp getStarted() {
		return started;
	}
	public void setStarted(Timestamp started) {
		this.started = started;
	}
	public Timestamp getTripCompleted() {
		return tripCompleted;
	}
	public void setTripCompleted(Timestamp tripCompleted) {
		this.tripCompleted = tripCompleted;
	}
	
}

package com.fuber.cabbooking.model;

public class Customer {
	
	private Preference preference;
	private String name;
	private Cab cabAssigned;
	private String totalAmount;
	private Location startLocation;
	private Location endLocation;
	
	public Preference getPreference() {
		return preference;
	}
	public void setPreference(Preference preference) {
		this.preference = preference;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Cab getCabAssigned() {
		return cabAssigned;
	}
	public void setCabAssigned(Cab cabAssigned) {
		this.cabAssigned = cabAssigned;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Location getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(Location startLocation) {
		this.startLocation = startLocation;
	}
	public Location getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(Location endLocation) {
		this.endLocation = endLocation;
	}
	
}

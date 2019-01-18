package com.fuber.cabbooking.model;

public class Amount {
	
	private String currencyType;
	private double value;
	
	
	public Amount(String type, double d) {
		this.currencyType = type;
		this.value = d;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	
	
	
}

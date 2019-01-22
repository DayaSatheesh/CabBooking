package com.fuber.cabbooking.test;

import java.util.List;

import javax.ws.rs.core.Response;

import com.fuber.cabbooking.model.Cab;
import com.fuber.cabbooking.service.BookingService;

public class TestBooking {

	public static void main (String[] args){
		
	}
	
	/**
	 * Assign cab and start ride. End ride. With preference
	 */
	public static void tcAssignCabWithPreference(){
		BookingService srv = new BookingService();
		Response response = srv.bookCab("112.33", "222.44", "Pink");
		System.out.println("Response after booking cab with preference - " + response.getStatus());
		System.out.println("Response after booking cab with preference - " + response.getEntity());
		
		Response resp = srv.endTrip("222.33", "333.66");
		System.out.println("after endong trip - " + resp.getEntity());
		
	}

	/**
	 * Assign cab and start ride. End ride. Without preference
	 */
	public static void tcAssignCabWithoutPreference(){
		BookingService srv = new BookingService();
		Response response = srv.bookCab("112.33", "222.44", null);
		System.out.println("Response after booking cab with preference - " + response.getStatus());
		System.out.println("Response after booking cab with preference - " + response.getEntity());
		
		Response resp = srv.endTrip("222.33", "333.66");
		System.out.println("after endong trip - " + resp.getEntity());
	}
	
	public static void tcGetAvailableCabs(){
		BookingService srv = new BookingService();
		List<Cab> cabs = srv.getAvailableCabs();
		cabs.forEach(cab -> System.out.println(cab.getCabNumber()));
	}
	
	
	
}

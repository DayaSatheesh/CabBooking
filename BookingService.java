package com.fuber.cabbooking.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.fuber.cabbooking.exception.FuberException;
import com.fuber.cabbooking.model.Amount;
import com.fuber.cabbooking.model.Cab;
import com.fuber.cabbooking.model.Customer;
import com.fuber.cabbooking.model.Location;
import com.fuber.cabbooking.model.Preference;

public class BookingService {
	
	public List<Cab> getAvailableCabs() throws FuberException {
		List<Cab> cabs = new ArrayList<>();
		int count = 10;
		while(count < 10){
			Cab c = createNewCab();
			if(c.isAvailable())
				cabs.add(c);
		}
		return cabs;
	}
	
	public Cab createNewCab(){
		Cab cab = new Cab();
		cab.setAvailable(true);
		cab.setCabLocation(null);
		cab.setCabNumber("001 002 0003");
		cab.setColour("white");
		return cab;
	}
	
	public Response bookCab(@QueryParam("latitude") String latitude,  @QueryParam("longitude") String longitude, @QueryParam("preference") String preference) throws FuberException{
		
		if(null != latitude && null != longitude){
			Customer customer = new Customer();
			customer.setStartLocation(new Location(latitude, longitude));
			customer.setPreference(new Preference(preference));
			
			List<Cab> availableCabs = getAvailableCabs();
			availableCabs.forEach(cab -> {
				if(null == customer.getCabAssigned()){
					assignCab(cab, customer);
				}
			});
			if(null != customer.getCabAssigned()){
				return Response.ok(customer.getCabAssigned()).build();
			}else{
				return Response.ok("No cabs available").build();
			}
		}else{
			return Response.ok("Error occurred. Resend request").build();
		}
	}
	
	public Response endTrip(@QueryParam("latitude") String latitude,  @QueryParam("longitude") String longitude) throws FuberException{
		
		if(null != latitude && null != longitude){
			Customer customer = new Customer();
			customer.setEndLocation(new Location(latitude, longitude));
			customer.setStartLocation(getStartLocation());
			
			Amount amount = endRide(getCabAssigned(), customer);
			if(null != amount){
				return Response.ok(amount).build();
			}else{
				return Response.ok("Error occurred").build();
			}
		}else{
			return Response.ok("Error occurred. Resend request").build();
		}
	}
	private void assignCab(Cab cab, Customer customer) throws FuberException{
		if(cab.isAvailable() && matchPreference(cab, customer)){
			double distBetween = getDistanceBetween(cab.getCabLocation().getLatitude(),
					customer.getStartLocation().getLatitude());
			if(distBetween <= 5000){
				startRide(cab, customer);
			}
		}
	}
	
	private boolean matchPreference(Cab cab, Customer customer){
		if(customer.getPreference().getColour().equals(cab.getColour()))
			return true;
		else
			return false;
	}
	
	private double getDistanceBetween(double loc1, double loc2) throws FuberException{
		double loc1square = Math.pow(loc1, 2);
		double loc2square = Math.pow(loc2, 2);
		
		if(loc1square - loc2square > 0){
			return Math.sqrt(loc1square - loc2square);
		}else{
			return Math.sqrt(loc2square - loc1square);
		}
	}
	
	private void startRide(Cab cab, Customer customer) throws FuberException{
		if(null != cab){
			cab.setAvailable(false);
			customer.setCabAssigned(cab);
			cab.setCabLocation(customer.getStartLocation());
			cab.setArrival(new Timestamp(System.currentTimeMillis()));
		}
	}
	
	private Amount endRide(Cab cab, Customer customer) throws FuberException {
		if(null != cab){
			cab.setAvailable(true);
			cab.setCabLocation(customer.getEndLocation());
			customer.setCabAssigned(null);
			return getTotalFarePayable(customer.getStartLocation(), customer.getEndLocation());
		}else{
			return null;
		}
	}
	
	private Amount getTotalFarePayable(Location loc1, Location loc2) throws FuberException{
		double distanceTravelled = getDistanceBetween(loc1.getLatitude(), loc2.getLatitude());
		return new Amount("DOG", distanceTravelled * 2);  
	}
	
	private Cab getCabAssigned(){
		//fetch the cab assigned details from DB
		return new Cab();
	}
	
	private Location getStartLocation() throws FuberException {
		//fetch the cab assigned details from DB
		return new Location("112.22", "122.44");
	}

}

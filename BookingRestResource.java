package com.fuber.cabbooking.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fuber.cabbooking.exception.FuberException;
import com.fuber.cabbooking.model.Cab;
import com.fuber.cabbooking.service.BookingService;

@Path("/booking")
public class BookingRestResource {
	
	private BookingService service = new BookingService();
	
	@GET
	@Path("/cabs")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cab> getAvailableCabs() throws FuberException {
		return service.getAvailableCabs();
	}
	
	@POST
	@Path("/book")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response bookCab(@QueryParam("latitude") String latitude,  @QueryParam("longitude") String longitude, @QueryParam("preference") String preference) throws FuberException{
		
		return service.bookCab(latitude, longitude, preference);
		
	}
	
	@POST
	@Path("/end")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)	
	public Response endTrip(@QueryParam("latitude") String latitude,  @QueryParam("longitude") String longitude) throws FuberException{
		return service.endTrip(latitude, longitude);
		
	}
	
}

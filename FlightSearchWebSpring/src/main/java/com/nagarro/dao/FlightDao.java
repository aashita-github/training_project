package com.nagarro.dao;

import java.util.Date;
import java.util.List;

import com.nagarro.model.Flights;

public interface FlightDao {

	public void addFlight(Flights flight);

	public List<Flights> getFlights(String arrivalLocation, String departLocation, Date flightDate, String flightClass);
	
	public List getArrivalLocations();
	
	public List getDepartureLocations();
}
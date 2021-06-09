package com.nagarro.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.nagarro.dto.Flight;

public interface FlightSearchDao {

	void addFlight(List<Flight> flights);
	
	List<Flight> getAvailableFlights(HttpServletRequest request);
	
	void addToDB();
	
	void removeFromDB();
}

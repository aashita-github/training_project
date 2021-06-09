package com.nagarro.service;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.FlightDao;
import com.nagarro.model.Flights;
import com.nagarro.utilities.DateParser;

@Service
public class FlightSearchService {
	@Autowired
	private FlightDao flightdao;
    public List<Flights> getSearchResult(String arrivalLocation, String departLocation, String date,
			String flightClass){
    	List<Flights> searchResult;
    	Date flightDate = (Date) DateParser.getDate(date);

		searchResult = flightdao.getFlights(arrivalLocation, departLocation, flightDate, flightClass);

		return searchResult;
    	
    }
	
	

}

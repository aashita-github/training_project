package com.nagarro.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.constants.FinalValues;
import com.nagarro.dao.FlightSearchDao;
import com.nagarro.dto.Flight;

@Service
public class FlightSearchService {

	@Autowired
	private FlightSearchDao flightSearchDao;
	
	public boolean validateLocationCode(String loc_code) {
		if(loc_code == null) {
			return false;
		}
		if (!(loc_code.length() == 3 && (loc_code != null) &&
				loc_code.chars().allMatch(Character::isLetter))) {
				return false;
		}
		return true;
	}
	
	public void addToDB() {
		flightSearchDao.addToDB();
	}
	
	public void removeFromDB() {
		flightSearchDao.removeFromDB();
	}
	
	public List<Flight> getAvailable(HttpServletRequest request){
		List<Flight> available = flightSearchDao.getAvailableFlights(request);
		return available;
	}
	
	public List<Flight> giveOutput(List<Flight> outputList, String output_preference, String flight_class){

		List<Flight> output = new ArrayList<Flight>();
		if (outputList.size() == 0) {
			return output;
		} else {
			if (output_preference.equalsIgnoreCase(FinalValues.BOTH)) {
				Collections.sort(outputList);
			} else {
				Collections.sort(outputList, new Comparator<Flight>() {
					@Override
					public int compare(Flight flight1, Flight flight2) {
						return flight1.getFare() - flight2.getFare();
					}
				});
			}
			output.addAll(outputList);
		}

		Iterator<Flight> iterator = output.iterator();
		Flight flight;
		while (iterator.hasNext()) {
			flight = (Flight) iterator.next();
			if (flight.getFlight_class().contains(flight_class)) {
				flight.setFlight_class(flight_class);
			} else {
				iterator.remove();
			}
			if (flight_class.equalsIgnoreCase(FinalValues.BUSINESS_CLASS)) {
				int fare = (int) (flight.getFare() * (1.4));
				flight.setFare(fare);
			}
		}
		return output;
	
	}
}

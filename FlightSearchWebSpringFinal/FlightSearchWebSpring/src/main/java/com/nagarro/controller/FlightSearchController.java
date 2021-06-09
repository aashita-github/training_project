package com.nagarro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.constants.FinalValues;
import com.nagarro.dto.Flight;
import com.nagarro.service.FlightSearchService;

@Controller
@SessionAttributes({ FinalValues.USER, FinalValues.AUTHORIZED, FinalValues.ERROR })
public class FlightSearchController {
	@Autowired
	private FlightSearchService flightSearchService;
	public List<Flight> available;

	@RequestMapping(value = "/flightsearch", method = RequestMethod.GET)
	public ModelAndView searchFlightGet(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("flightsearch");
		return mv;
	}

	@RequestMapping(value = "/flightsearch", method = RequestMethod.POST)
	public ModelAndView searchFlight(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String dep_loc = request.getParameter("dep_loc");
		String arr_loc = request.getParameter("arr_loc");
		boolean validDepLoc = flightSearchService.validateLocationCode(dep_loc);
		boolean validArrLoc = flightSearchService.validateLocationCode(arr_loc);
		if (!(validDepLoc || validArrLoc)) {
			if (!validDepLoc) {
				mv.addObject(FinalValues.ERROR, "Departure Location is Invalid.");
				mv.setViewName("flightsearch");
			}

			if (!validArrLoc) {
				mv.addObject(FinalValues.ERROR, "Arrival Location is Invalid.");
				mv.setViewName("flightsearch");
			}
			return mv;
		} else {
			flightSearchService.removeFromDB();
			flightSearchService.addToDB();
			available = flightSearchService.getAvailable(request);
			String output_preference = request.getParameter("output_preference");
			String flight_class = request.getParameter("flight_class");
			if (flight_class.equalsIgnoreCase("economy")) {
				flight_class = FinalValues.ECONOMY_CLASS;
			} else {
				flight_class = FinalValues.BUSINESS_CLASS;
			}
			available = flightSearchService.giveOutput(available, output_preference, flight_class);
			if (available.isEmpty()) {
				mv.addObject(FinalValues.ERROR, "No Flights Available for the provided information");
				mv.setViewName("flightsearch");
			} else {
				mv.addObject("available", available);
				mv.setViewName("show");
			}
			return mv;
		}
	}

}

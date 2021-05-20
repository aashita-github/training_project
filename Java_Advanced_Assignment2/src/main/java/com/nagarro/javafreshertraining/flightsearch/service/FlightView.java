package com.nagarro.javafreshertraining.flightsearch.service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.nagarro.javafreshertraining.flightsearch.model.Flights;

/**
 * @author aashita Comparator to compare enteries by fare or duration as
 *         specified an print them.
 */
public class FlightView {

	public static void viewFlightsByFare(Set<Flights> unsortedlistbyfare) {

		try {
			List<Flights> list1 = unsortedlistbyfare.stream().sorted(new Comparator<Flights>() {
				@Override
				public int compare(Flights o1, Flights o2) {
					if (o1.getFare() == o2.getFare())
						return o1.getFlightNo().compareTo(o2.getFlightNo());
					else if (o1.getFare() > o2.getFare())
						return 1;
					else
						return -1;
				}
			}).collect(Collectors.toList());
			System.out.println("\n \t\t\t ***** FLIGHT INFORMATION *****");
			System.out.println(
					"FLIGHT_NO|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FARE  |FLIGHT_DURN|CLASS_TYPE|SEAT_AVAILABILITY\n");
			for (Flights b : list1) {
				if (b.getClassType().equals("B")) {
					System.out.println(b.getFlightNo() + "\t |" + b.getDepLoc() + "\t | " + b.getArrLoc() + "\t |"
							+ b.getValidTill() + "| " + b.getFlightTime() + "\t |" + (b.getFare() * 1.4) + "\t| "
							+ b.getFlightDur() + "  \t|" + b.getClassType() + "\t |" + b.getSeatAvailability()
							+ "\t| ");
				}
				System.out.println(b.getFlightNo() + "\t |" + b.getDepLoc() + "\t | " + b.getArrLoc() + "\t |"
						+ b.getValidTill() + "| " + b.getFlightTime() + "\t |" + (b.getFare()) + "\t| "
						+ b.getFlightDur() + "  \t|" + b.getClassType() + "\t |" + b.getSeatAvailability() + "\t| ");
			}

			if (unsortedlistbyfare.size() == 0) {
				System.out.println("\n\tFlights Not Available For Provided Arrival and Departure On Date Entered !\t\n");
			}
		} catch (java.lang.NullPointerException e) {
			System.out.println("\nArrival and Departure location not present!\n");
		}

	}

	public static void viewFlightsByTime(Set<Flights> unsortedlistbytime) {
		try {
			List<Flights> list2 = unsortedlistbytime.stream().sorted(new Comparator<Flights>() {
				@Override
				public int compare(Flights o1, Flights o2) {
					if (o1.getFlightDur() == o2.getFlightDur())
						return o1.getFlightNo().compareTo(o2.getFlightNo());
					else if (o1.getFlightDur() > o2.getFlightDur())
						return 1;
					else
						return -1;
				}
			}).collect(Collectors.toList());
			System.out.println("\n \t\t\t ***** FLIGHT INFORMATION *****");
			System.out.println(
					"FLIGHT_NO|DEP_LOC|ARR_LOC|VALID_TILL|FLIGHT_TIME|FARE  |FLIGHT_DURN|CLASS_TYPE|SEAT_AVAILABILITY\n");
			for (Flights b : list2) {
				if (b.getClassType().equals("B")) {
					System.out.println(b.getFlightNo() + "\t |" + b.getDepLoc() + "\t | " + b.getArrLoc() + "\t |"
							+ b.getValidTill() + "| " + b.getFlightTime() + "\t |" + (b.getFare() * 1.4) + "\t| "
							+ b.getFlightDur() + "  \t|" + b.getClassType() + "\t |" + b.getSeatAvailability()
							+ "\t| ");
				}
				System.out.println(b.getFlightNo() + "\t |" + b.getDepLoc() + "\t | " + b.getArrLoc() + "\t |"
						+ b.getValidTill() + "| " + b.getFlightTime() + "\t |" + (b.getFare()) + "\t| "
						+ b.getFlightDur() + "  \t|" + b.getClassType() + "\t |" + b.getSeatAvailability() + "\t| ");
			}

			if (unsortedlistbytime.size() == 0) {
				System.out.println("\n\tFlights Not Available For Provided Arrival and Departure On Date Entered !\t\n");
			}
		} catch (java.lang.NullPointerException e) {
			System.out.println("Arrival and Departure location not present!");
		}
	}
}

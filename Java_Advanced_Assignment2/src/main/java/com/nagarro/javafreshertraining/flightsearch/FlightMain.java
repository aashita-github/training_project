package com.nagarro.javafreshertraining.flightsearch;

import java.util.Scanner;

import org.hibernate.HibernateException;

import com.nagarro.javafreshertraining.flightsearch.hibernate.HibernateUtil;
import com.nagarro.javafreshertraining.flightsearch.service.AvailableFlights;
import com.nagarro.javafreshertraining.flightsearch.service.FlightInput;
import com.nagarro.javafreshertraining.flightsearch.service.FlightService;

/**
 * @author aashita
 *Main function to run the flight search program
 */
public class FlightMain {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		System.out.println("hello");

		FlightService.loadCSV();
		Object ans = null;

		try {
			do {

				FlightInput.input();
				AvailableFlights.flightsAvailable();
				System.out.print("Do You Want To Continue ( Y / N ) ?");
				Scanner sc = new Scanner(System.in);
				ans = sc.nextLine();

			} while (ans.equals("Y") || ans.equals("y"));

		} catch (HibernateException e) {
			System.out.print(e.getMessage());
		} finally {

			HibernateUtil.shutdown();
		}

	}

}

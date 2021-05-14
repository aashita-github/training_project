package com.service.reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author aashita
 * 
 *Main class to take input and search fligts accordingly from map
 */
public class FlightMain {

	public static void main(String args[]) throws FileNotFoundException {
		String ans;
		FlightService.flightUtility();
		do {
			List<Flight> unsortedlistbyfare = null;
			List<Flight> unsortedlistbytime = null;
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			String dept_loc, arrival_loc, date, class_ty;
			int choiceCode;
			System.out.print("\nEnter Departure Location  : ");
			dept_loc = sc.nextLine().toUpperCase();
			System.out.print("Enter Arrival Location  : ");
			arrival_loc = sc.nextLine().toUpperCase();
			System.out.print("Enter Date (DD-MM-YYYY)   : ");
			date = sc.nextLine().toUpperCase();
			System.out.print("Enter Class ( E / B / EB )   : ");
			class_ty = sc.nextLine().toUpperCase();
			System.out.print(
					"Enter Output Preference :   1. Fare \t 2. Flight Duration \nEnter Preference Choice Code : ");
			choiceCode = sc.nextInt();
			Map<String, Set<Flight>> cacheMap = FlightService.map;

			if (cacheMap.containsKey(dept_loc + arrival_loc)) {
				Set<Flight> flightList = cacheMap.get(dept_loc + arrival_loc);
				unsortedlistbyfare = new ArrayList<>();
				unsortedlistbytime = new ArrayList<>();

				for (Flight obj : flightList) {
					if ((obj.getValidTill().equals(date)) && (obj.getClassType().equals(class_ty))) {

						if (choiceCode == 1) {
							unsortedlistbyfare.add(obj);

						}

						else if (choiceCode == 2) {
							unsortedlistbytime.add(obj);

						}

						else
							System.out.println("Wrong Choice.");

					}

				}
			}

			if (choiceCode == 1)
				FlightView.viewFlightsByFare(unsortedlistbyfare);
			else if (choiceCode == 2)
				FlightView.viewFlightsByTime(unsortedlistbytime);
			System.out.print("Do You Want To Continue ( Y / N ) ?");
			ans = sc.next();
		} while (ans.equals("Y")||ans.equals("y"));

	}

}

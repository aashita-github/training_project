package com.nagarro.javafreshertraining.flightsearch.service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author aashita
 *To Validate input 
 */
public class Validations {
	static String depLoc, arrLoc, validTill, classType;
	static int choiceCode;
	static Scanner sc = new Scanner(System.in);

	public static void choiceValidation() {
		while (true) {
			try {
				choiceCode = Integer.parseInt(sc.nextLine());
				if (choiceCode == 1 || choiceCode == 2)
					break;
				else
					System.out.print("Enter a valid choiceCode (1 / 2 ) : ");
			} catch (NumberFormatException e) {
				System.out.print("Enter a number : ");

				continue;
			}
		}

	}

	public static void departureValidation() {
		while (true) {
			depLoc = sc.nextLine().toUpperCase();
			if (!depLoc.isEmpty() && depLoc.length() == 3 && depLoc.matches("[A-Za-z]*")) {
				break;
			} else if (depLoc.isEmpty()) {
				System.out.print("Mandatory!...Enter a Departure Location : ");
				continue;
			} else if (depLoc.length() != 3) {
				System.out.print("Enter a Valid Departure Location : ");
				continue;
			} else if (!depLoc.matches("[A-Za-z]*")) {
				System.out.print("Enter a Valid Departure Location : ");
				continue;
			}
		}
	}

	public static void arrivalValidation() {
		while (true) {
			arrLoc = sc.nextLine().toUpperCase();
			if (!arrLoc.isEmpty() && arrLoc.length() == 3 && arrLoc.matches("[A-Za-z]*")) {
				break;
			} else if (arrLoc.isEmpty()) {
				System.out.print("Mandatory!...Enter a Arrival Location : ");
				continue;
			} else if (arrLoc.length() != 3) {
				System.out.print("Enter a Valid Arrival Location : ");
				continue;
			} else if (!arrLoc.matches("[A-Za-z]*")) {
				System.out.println("Enter a Valid Arrival Location : ");
				continue;
			}
		}

	}

	public static void classTypeValidation() {
		while (true) {
			classType = sc.nextLine().toUpperCase();
			if (classType.isEmpty()) {
				System.out.print("Mandatory!..Enter Class Type ( E / B / EB )  : ");
				continue;
			} else if (classType.equalsIgnoreCase("E") || classType.equalsIgnoreCase("B")
					|| classType.equalsIgnoreCase("ËB")) {
				break;

			} else {
				System.out.print("Enter Valid Class Type ( E / B / EB )   : ");
				continue;

			}
		}
	}

	public static void dateValidation() {

		String regex = "^[0-3]?[0-9]-[0-3]?[0-9]-(?:[0-9]{2})?[0-9]{2}$";
		Pattern pattern = Pattern.compile(regex);
		while (true) {
			validTill = sc.nextLine();
			Matcher matcher = pattern.matcher(validTill);

			if (matcher.matches()) {
				break;
			} 
			else if(validTill.isEmpty())
			{
				System.out.print("Mandatory!...Enter a Valid Date (DD-MM-YYYY) :  ");
		}
			else if (!matcher.matches()) {
				System.out.print("Enter a Valid Date (DD-MM-YYYY) :  ");
				continue;
			}

	}
}
}
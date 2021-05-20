package com.nagarro.javafreshertraining.flightsearch.service;

/**
 * @author aashita
 *To take user inputs
 */
public class FlightInput {


	public static void input() {
		
		System.out.print("\nEnter Departure Location  : ");
		Validations.departureValidation();
		System.out.print("Enter Arrival Location  : ");
		Validations.arrivalValidation();
		System.out.print("Enter Date (DD-MM-YYYY)   : ");
		Validations.dateValidation();
		System.out.print("Enter Class ( E / B / EB )   : ");
		Validations.classTypeValidation();		
		System.out.print("Enter Output Preference :   1. Fare \t 2. Flight Duration \nEnter Preference Choice Code : ");
		Validations.choiceValidation();
	}
}

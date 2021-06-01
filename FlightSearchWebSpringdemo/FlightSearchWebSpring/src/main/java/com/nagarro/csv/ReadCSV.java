package com.nagarro.csv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.nagarro.constants.FinalValues;
import com.nagarro.dto.Flight;
import com.opencsv.CSVReader;

public class ReadCSV {


	@SuppressWarnings("finally")
	public List<Flight> read(String path) {

		List<Flight> flight = new ArrayList<>();
		try {
			CSVReader csvreader = new CSVReader(new FileReader(path));
			String line[];
			csvreader.readNext();

			while ((line = csvreader.readNext()) != null) {
				Flight flightoutput = createFlight(line);
				flight.add(flightoutput);
			}

		} catch (FileNotFoundException ex) {
			System.err.println(FinalValues.FILE_EXCEPTION);
		} catch (IOException ex) {
			System.err.println(FinalValues.IO_EXCEPTION);
		} finally {
		return flight;
		}
	}

	private String convertDate(String line) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(line.subSequence(6, 10));
		buffer.append("-");
		buffer.append(line.subSequence(3, 5));
		buffer.append("-");
		buffer.append(line.subSequence(0, 2));
		String date = buffer.toString();
		return date;
	}

	private Flight createFlight(String[] line) {
		String flight_no = line[0];
		String dep_loc = line[1];
		String arr_loc = line[2];
		String flight_time = line[4];
		float duration = Float.parseFloat(line[5]);
		int fare = Integer.parseInt(line[6]);
		String seat_availability = line[7];
		String flight_class = line[8];
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		String date = convertDate(line[3]);
		LocalDate flight_date = LocalDate.parse(date, formatter);
		if (flight_class == FinalValues.BUSINESS_CLASS) {
			fare += (int) fare * (FinalValues.BUSINESS_TAX);
		}
		return new Flight(flight_no, dep_loc, arr_loc, flight_time, flight_class, seat_availability, fare, duration,
				flight_date);
	}
}

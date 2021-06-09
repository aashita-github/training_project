package com.nagarro.constants;

import java.text.SimpleDateFormat;

public class Constants {

	public static final String DATEFORMAT = "yyyy-MM-dd";
	public static final String FOLDERPATH = "C:\\Users\\aashita\\eclipse-workspace\\FlightSearchWebSpring\\FlightData";
	

	public static SimpleDateFormat getDateFormatter() {
		return new SimpleDateFormat(DATEFORMAT);
	}

}
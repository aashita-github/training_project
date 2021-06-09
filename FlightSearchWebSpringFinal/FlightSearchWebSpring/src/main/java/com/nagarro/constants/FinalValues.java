package com.nagarro.constants;

public class FinalValues {
	public static final String PATH = "D:\\FlightSearchWebSpringdemo\\FlightSearchWebSpring\\csv";
	public static final String FILE_EXCEPTION = "File not found exception";
	public static final String IO_EXCEPTION = "IOException";
	public static final String BUSINESS_CLASS = "B";
	public static final String ECONOMY_CLASS = "E";
	public static final String IS_LOGIN_SUCCESSFUL_HQL = "from LoginDetails where username=:unm and password=:pass";
	public static final String GET_AVAILABLE_FLIGHTS_HQL = "from Flight where dep_loc=:dep_loc and arr_loc=:arr_loc and seat_availability = 'Y' and flight_date >= :date";
	public static final String DELETE_HQL = "DELETE FROM Flight";
	public static final String GET_USER_ID_HQL = "from LoginDetails where username=:unm and password=:pass";
	public static final String GET_USER_ID_UNM_HQL = "from LoginDetails where username=:unm";
	public static final String UNM = "unm";
	public static final String PASS = "pass";
	public static final String BOTH = "both";
	public static final String AUTHORIZED = "authorized";
	public static final String USER = "user";
	public static final String ERROR = "error";
	public static final String PHONE = "phone";
	public static final float BUSINESS_TAX = (float) 0.4;
}

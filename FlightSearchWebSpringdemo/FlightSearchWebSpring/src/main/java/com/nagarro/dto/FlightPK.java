package com.nagarro.dto;
import java.io.Serializable;

public class FlightPK implements Serializable{

	private static final long serialVersionUID = -6164824558804426972L;
	protected String flight_no;
	protected String flight_time;
	
	public FlightPK() {}
	public FlightPK(String flight_no, String flight_time) {
		super();
		this.flight_no = flight_no;
		this.flight_time = flight_time;
	}
	
}
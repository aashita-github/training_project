package com.nagarro.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(FlightPK.class)
public class Flight implements Comparable<Flight> {
	@Id
	private String flight_no;
	private String dep_loc;
	private String arr_loc;
	@Id
	private String flight_time;
	private String flight_class;
	private String seat_availability;
	private int fare;
	private float duration;
	private LocalDate flight_date;
	
	public Flight() {}
	public Flight(String flight_no, String dep_loc, String arr_loc, String flight_time, String flight_class,
			String seat_availability, int fare, float duration, LocalDate flight_date) {
		this.flight_no = flight_no;
		this.dep_loc = dep_loc;
		this.arr_loc = arr_loc;
		this.flight_time = flight_time;
		this.flight_class = flight_class;
		this.seat_availability = seat_availability;
		this.fare = fare;
		this.duration = duration;
		this.flight_date = flight_date;
	}

	public int getFare() {
		return fare;
	}
	
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getFlight_no() {
		return flight_no;
	}

	public String getDep_loc() {
		return dep_loc;
	}

	public String getArr_loc() {
		return arr_loc;
	}

	public String getFlight_time() {
		return flight_time;
	}

	public String getFlight_class() {
		return flight_class;
	}
	
	public void setFlight_class(String flight_class) {
		this.flight_class=flight_class;
	}
	
	public String getSeat_availability() {
		return seat_availability;
	}

	public float getDuration() {
		return duration;
	}

	public LocalDate getFlight_date() {
		return flight_date;
	}

	@Override
	public int compareTo(Flight obj) {
		if (obj.getFare() > this.getFare()) {
			return -1;
		} else if (obj.getFare() < this.getFare()) {
			return 1;
		} else {
			return (Float.valueOf(getDuration()).compareTo(obj.getDuration()));
		}
	}
}
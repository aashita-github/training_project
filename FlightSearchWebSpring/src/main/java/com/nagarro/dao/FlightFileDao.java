package com.nagarro.dao;

import java.util.List;

import com.nagarro.model.FlightFile;

public interface FlightFileDao {
	
	public List<FlightFile> getAllFlightFiles();
	public FlightFile getFlightFile(String fileName);
	public void updateFlightFile(FlightFile flightFile);
	public void addFlightFile(FlightFile newFlightFile);
	
}
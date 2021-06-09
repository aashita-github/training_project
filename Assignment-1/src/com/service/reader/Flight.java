package com.service.reader;

/**
 * @author aashita
 *Flight class to get and set data 
 */
public class Flight {
	
	private String flightNo;
	private String depLoc;
	private String arrLoc;
	private String validTill ;
	private String flightTime;
	private float flightDur;
	private int fare;
	private String seatAvailability;
	private String classType;
	public String getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	public String getDepLoc() {
		return depLoc;
	}
	public void setDepLoc(String depLoc) {
		this.depLoc = depLoc;
	}
	public String getArrLoc() {
		return arrLoc;
	}
	public void setArrLoc(String arrLoc) {
		this.arrLoc = arrLoc;
	}
	public String getValidTill() {
		return validTill;
	}
	public void setValidTill(String validTill) {
		this.validTill = validTill;
	}
	public String getFlightTime() {
		return flightTime;
	}
	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}
	public float getFlightDur() {
		return flightDur;
	}
	public void setFlightDur(float flightDur) {
		this.flightDur = flightDur;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getSeatAvailability() {
		return seatAvailability;
	}
	public void setSeatAvailability(String seatAvailability) {
		this.seatAvailability = seatAvailability;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrLoc == null) ? 0 : arrLoc.hashCode());
		result = prime * result + ((classType == null) ? 0 : classType.hashCode());
		result = prime * result + ((depLoc == null) ? 0 : depLoc.hashCode());
		result = prime * result + fare;
		result = prime * result + Float.floatToIntBits(flightDur);
		result = prime * result + ((flightNo == null) ? 0 : flightNo.hashCode());
		result = prime * result + ((flightTime == null) ? 0 : flightTime.hashCode());
		result = prime * result + ((seatAvailability == null) ? 0 : seatAvailability.hashCode());
		result = prime * result + ((validTill == null) ? 0 : validTill.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (arrLoc == null) {
			if (other.arrLoc != null)
				return false;
		} else if (!arrLoc.equals(other.arrLoc))
			return false;
		if (classType == null) {
			if (other.classType != null)
				return false;
		} else if (!classType.equals(other.classType))
			return false;
		if (depLoc == null) {
			if (other.depLoc != null)
				return false;
		} else if (!depLoc.equals(other.depLoc))
			return false;
		if (fare != other.fare)
			return false;
		if (Float.floatToIntBits(flightDur) != Float.floatToIntBits(other.flightDur))
			return false;
		if (flightNo == null) {
			if (other.flightNo != null)
				return false;
		} else if (!flightNo.equals(other.flightNo))
			return false;
		if (flightTime == null) {
			if (other.flightTime != null)
				return false;
		} else if (!flightTime.equals(other.flightTime))
			return false;
		if (seatAvailability == null) {
			if (other.seatAvailability != null)
				return false;
		} else if (!seatAvailability.equals(other.seatAvailability))
			return false;
		if (validTill == null) {
			if (other.validTill != null)
				return false;
		} else if (!validTill.equals(other.validTill))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flight [flightNo=" + flightNo + ", depLoc=" + depLoc + ", arrLoc=" + arrLoc + ", validTill=" + validTill
				+ ", flightTime=" + flightTime + ", flightDur=" + flightDur + ", fare=" + fare + ", seatAvailability="
				+ seatAvailability + ", classType=" + classType + "]";
	}
	
	
	

	
}

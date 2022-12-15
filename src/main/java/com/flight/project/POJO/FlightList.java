package com.flight.project.POJO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "flightList")
public class FlightList {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fliID")
	public int fliID;
	

	public int flightID;
	
	@Column(name = "flightName")
	public String flightName;
	
	@Column(name = "fromplace")
	public String fromplace;
	
	@Column(name = "toplace")
	public String toplace;
	
	@Column(name = "flightCompany")
	public String flightCompany;
	
	
	public String getFlightCompany() {
		return flightCompany;
	}

	public void setFlightCompany(String flightCompany) {
		this.flightCompany = flightCompany;
	}
	
	@Column(name = "departureTime")
	public String departureTime;
	
	@Column(name = "arrivalTime")
	public String arrivalTime;
	
	@Column(name = "departureDate")
	public String departureDate;
	
	@Column(name = "arrivalDate")
	public String arrivalDate;
	
	@Column(name = "travleClass")
	public String travleClass;
	
	@Column(name = "totalSeats")
	public int totalSeats;
	
	@Column(name = "noSeatsAvaialable")
	public int noSeatsAvaialable;
	
	@Column(name = "price")
	public int price;
	
	
	public FlightList() {
		
	}

	
	public FlightList( int flightID, String flightName, String fromplace, String toplace, String departureTime, String arrivalTime,
		String departureDate, String arrivalDate, String travleClass, int totalSeats, int noSeatsAvaialable, int price) {
//	super();
	this.fromplace = fromplace;
	this.flightID = flightID;
	this.flightName = flightName;
	this.toplace = toplace;
	this.departureTime = departureTime;
	this.arrivalTime = arrivalTime;
	this.departureDate = departureDate;
	this.arrivalDate = arrivalDate;
	this.travleClass = travleClass;
	this.totalSeats = totalSeats;
	this.noSeatsAvaialable = noSeatsAvaialable;
	this.price = price;
}

	public String getFromplace() {
		return fromplace;
	}

	public void setFromplace(String fromplace) {
		this.fromplace = fromplace;
	}

	public String getToplace() {
		return toplace;
	}

	public void setToplace(String toplace) {
		this.toplace = toplace;
	}

	public int getFliID() {
		return fliID;
	}
	public void setFliID(int fliID) {
		this.fliID = fliID;
	}
	public int getFlightID() {
		return flightID;
	}
	public void setFlightID(int flightID) {
		this.flightID = flightID;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public String getTravleClass() {
		return travleClass;
	}
	public void setTravleClass(String travleClass) {
		this.travleClass = travleClass;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}
//	public int getNoSeatsAvaialable() {
//		return NoSeatsAvaialable;
//	}
//	public void setNoSeatsAvaialable(int NoSeatsAvaialable) {
//		this.NoSeatsAvaialable = NoSeatsAvaialable;
//	}
	public int getPrice() {
		return price;
	}
	public int getNoSeatsAvaialable() {
		return noSeatsAvaialable;
	}

	public void setNoSeatsAvaialable(int noSeatsAvaialable) {
		this.noSeatsAvaialable = noSeatsAvaialable;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}

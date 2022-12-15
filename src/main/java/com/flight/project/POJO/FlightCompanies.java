package com.flight.project.POJO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="flight_companies")
public class FlightCompanies {
	
	@Id
	@GeneratedValue
	@Column(name="flightiD", unique=true, nullable=false)
	public int flightiD;
	
	@Column(name="flightname")
	public String fightname;
	
	@Column(name="flightcompany")
	public String flightcompany;
	

	@OneToMany( cascade = CascadeType.ALL)
	@JoinColumn(name = "flightID",referencedColumnName = "flightiD")
	private Set<FlightList> flightsList = new HashSet<FlightList>();
	
	
	public Set<FlightList> getFlightsList() {
		return flightsList;
	}

	public void setFlightsList(Set<FlightList> flightsList) {
	this.flightsList = flightsList;
	}

	public FlightCompanies() {
		
	}
	
	public FlightCompanies(String flightname, String flightcompany ) {
		this.fightname = flightname;
		this.flightcompany = flightcompany;
	}

	

	public int getFlightiD() {
		return flightiD;
	}

	public void setFlightiD(int flightiD) {
		this.flightiD = flightiD;
	}

	public String getFightname() {
		return fightname;
	}

	public void setFightname(String fightname) {
		this.fightname = fightname;
	}

	public String getFlightcompany() {
		return flightcompany;
	}

	public void setFlightcompany(String flightcompany) {
		this.flightcompany = flightcompany;
	}
	
	
	
	

	

}

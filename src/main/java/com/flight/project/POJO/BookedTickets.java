package com.flight.project.POJO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BookedTickets")
public class BookedTickets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ticketID", unique= true, nullable=false)
	public int ticketID;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "TravID")
	Travellers travellers;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="fliID")
	FlightList flightlist;
	
	public BookedTickets() {
		
	}

	public int getTicketID() {
		return ticketID;
	}

	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}

	public Travellers getTravellers() {
		return travellers;
	}

	public void setTravellers(Travellers travellers) {
		this.travellers = travellers;
	}

	public FlightList getFlightlist() {
		return flightlist;
	}

	public void setFlightlist(FlightList flightlist) {
		this.flightlist = flightlist;
	}

	public BookedTickets(Travellers travellers, FlightList flightlist) {
		super();
		this.travellers = travellers;
		this.flightlist = flightlist;
	}

	
	
	
	
}

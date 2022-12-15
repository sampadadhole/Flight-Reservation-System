package com.flight.project.POJO;

import java.util.ArrayList;

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
import com.flight.project.POJO.AirlineUsers;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Travellers")
public class Travellers {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TravID", unique=true, nullable=false)
	public int TravID;
	
	@Column(name="firstName")
	public String firstName;
	
	@Column(name="lastName")
	public String lastName;
	
	@Column(name="gender")
	public String gender;
	
	@Column(name="email")
	public String email;
	
	@Column(name="dateOfBirth")
	public String dateOfBirth;
	
	@Column(name="address")
	public String address;
	
	@Column(name="passportNo")
	public String passportNo;
	
	@Column(name="phoneNum")
	public String phoneNum;
	

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.EAGER)
	@JoinColumn(name="Username")
	public AirlineUsers airlineusers;
	
	public String airlineUsername;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	public AirlineUsers users;
	public Travellers() {
		
	}

	public Travellers(String firstName, String lastName, String gender, String email, String dateOfBirth,
			String phoneNum, String address, String passportNo, String airlineUsername) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.airlineUsername= airlineUsername;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.passportNo = passportNo;
		this.phoneNum = phoneNum;
	}

	

	public String getAirlineUsername() {
		return airlineUsername;
	}

	public void setAirlineUsername(String airlineUsername) {
		this.airlineUsername = airlineUsername;
	}

	public int getTravID() {
		return TravID;
	}

	public void setTravID(int travID) {
		this.TravID = travID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public AirlineUsers getAirlineusers() {
		return airlineusers;
	}

	public void setAirlineusers(AirlineUsers users) {
		this.airlineusers = users;
		
	}

	
	
	
}

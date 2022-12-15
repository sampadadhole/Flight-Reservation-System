package com.flight.project.POJO;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//@Component
@Entity
@Table(name="AirlineUsers")
public class AirlineUsers  {
	
	@Id
	@Column(name="Userid", unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int UserId;
	

	@Column(name="Username")
	public String Username;
	
	@Column(name="Userpassword")
	public String Userpassword;
	
	@Column(name="Userrole")
	public String Userrole;
	
	@Column(name="UIN", unique=true)
	public int UIN;
	

	@OneToMany(mappedBy="airlineusers",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Travellers> travellersList = new ArrayList<>();
	
	


//	public void addTravller(Travellers travl) {
//		if(travl!=null) {
//			if(travl == null) {
//				travellersList = new ArrayList<>();
//			}
//			travellersList.add(travl);
//		}
//	
//	}

//	public List<Travellers> getTravellers() {
//		return travellersList;
//	}
//
//
//	public void setTravellers(List<Travellers> travellers) {
//		this.travellersList = travellers;
//	}

//	public void AddTravellerDetails(Travellers travellers) {
//		System.out.print("AddTravellerDetails");
//		if (travellersList == null) {
//			travellersList = new ArrayList<>();
//		}
//		travellers.airlineusers = this;
//		travellersList.add(travellers);
//		
//	}

	public AirlineUsers() {
		
	}
	
	
	
	public AirlineUsers(String Username, String userpassword, String userrole, int UIN) {
		super();
		this.Username = Username;
		this.Userpassword = userpassword;
		this.Userrole = userrole;
		this.UIN = UIN;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		this.UserId = userId;
		
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		this.Username = username;
	}

	public String getUserpassword() {
		return Userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.Userpassword = userpassword;
	}

	public String getUserrole() {
		return Userrole;
	}

	public void setUserrole(String userrole) {
		this.Userrole = userrole;
	}
	
	public int getUIN() {
		return UIN;
	}


	public void setUIN(int UIN) {
		this.UIN = UIN;
	}


	
}

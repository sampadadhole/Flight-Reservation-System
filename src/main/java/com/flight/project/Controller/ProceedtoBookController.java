package com.flight.project.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.flight.project.DAO.FlightDetailsDAO;
import com.flight.project.DAO.PassangerDAO;
import com.flight.project.DAO.ShowFlightsDAO;
import com.flight.project.POJO.AirlineUsers;
import com.flight.project.POJO.FlightCompanies;
import com.flight.project.POJO.FlightList;
import com.flight.project.POJO.Travellers;

import ErrorException.FException;

@Controller
public class ProceedtoBookController {

	
	@GetMapping("/ProceedtoBook.htm")
	public String Enter() {

		return "ProceedtoBook";
	}
	
	@PostMapping("/ProceedtoBook.htm")
	public String GiveInputs(HttpServletRequest request, @ModelAttribute("CheckoutPassengerDetails") Travellers travellers) {

		return "EnterPassengerDetails";
		
	}
	
	@GetMapping("/EnterPassengerDetails.htm")
		public String details(HttpServletRequest request, FlightDetailsDAO fdao) throws FException {
		HttpSession session = request.getSession();
	
		int noOfTravllers = Integer.valueOf(request.getParameter("noOfTravllers"));
		session.setAttribute("noOfTravllers", noOfTravllers);
		System.out.print("noOfTravllers in details:"+noOfTravllers);
		int fid = Integer.valueOf((String) session.getAttribute("fid"));
		System.out.print("fid in details:"+fid);
		FlightList fl = fdao.get(fid);
		int NoOfSeatsAvaialbale = fl.getNoSeatsAvaialable();
		System.out.print("NoOfSeatsAvaialbale in details:"+NoOfSeatsAvaialbale);
		try {
			if(noOfTravllers < NoOfSeatsAvaialbale) {
				return "EnterPassengerDetails";
			}
			else {
				return "notenoughseats";
			}
		}
		catch(Exception e) {
			throw new FException("Exception in seats"+e);
		}
		
			
		}
	
	@PostMapping("/EnterPassengerDetails.htm")
	public String Enterdetails(HttpServletRequest request, @ModelAttribute("PassengerDetails") Travellers travellers, AirlineUsers airlineusers, FlightDetailsDAO fdao, ShowFlightsDAO showdao) throws Exception {
		
	
	        HttpSession session = request.getSession();
	        int noOfTravllers = (int) session.getAttribute("noOfTravllers");
	        
	        System.out.print("no of passengers entered: "+noOfTravllers );
	        String username = (String) session.getAttribute("Username");
			System.out.println("Username" + username);
			int fid = Integer.valueOf((String) session.getAttribute("fid"));
			System.out.println("fid" + fid);
			FlightList fl = fdao.get(fid);
			int NoOfSeatsAvaialbale = fl.getNoSeatsAvaialable();
			session.setAttribute("flightdetails", fl);

	        try {
//	        
	        	String registeredUserName = (String) session.getAttribute("Username");
	        	String[] firstNames = request.getParameterValues("firstName");
	        	String[] lastNames = request.getParameterValues("lastName");
	        	String[] gens = request.getParameterValues("gender");
	        	String[] Emails = request.getParameterValues("email");
	        	String[] dobs = request.getParameterValues("dateOfBirth");
	        	String[] phones = request.getParameterValues("phoneNum");
	        	String[] addrs = request.getParameterValues("address");
	        	String[] passports = request.getParameterValues("passportNo");
	        	for(int i=0;i<firstNames.length;i++) {
	        		 PassangerDAO dao = new PassangerDAO();
	        		 Travellers travl = dao.createTraveller(firstNames[i], lastNames[i], gens[i], Emails[i], dobs[i], phones[i], addrs[i], passports[i], registeredUserName);
	        		 int travl_id = travl.getTravID();
	       		 System.out.println("travllers id Enterdetails:" +travl_id);
	       		 session.setAttribute("travl_id" + i, travl_id);
	        	}
	        	
//	        		 int TravID = travl.getTravID();
//	        		 System.out.println("travelID:" +TravID );
////	        		 System.out.println("UserID:" +travl.getAirlineusers());
//	        		 session.setAttribute("TravID", TravID);
//	        		 System.out.println("ftravl"+ travl);
	        	
//	        	else {
//	        		System.out.println("Not enough seats to book the ticket.");
//	        	}
	        }
//	        try {
//	        	PassangerDAO dao = new PassangerDAO();
//	        	String first = travellers.getFirstName();
//	        	System.out.println("first name:" + first);
//	        	
//	        	String last = travellers.getLastName();
//	        	System.out.println("last name:" + last);
//	        	
//	        	String gen = travellers.getGender();
//	        	System.out.println("gen: " + gen);
//	        	
//	        	String email = travellers.getEmail();
//	        	System.out.println("email:" + email);
//	        	
//	        	String dob = travellers.getDateOfBirth();
//	        	System.out.println("dob:" + dob);
//	        	
//	        	String phone = travellers.getPhoneNum();
//	        	System.out.println("phone: " + phone);
//	        	
//	        	String add = travellers.getAddress();
//	        	System.out.println("add:" + add);
//	        	
//	        	String pass = travellers.getPassportNo();
//	        	System.out.println("pass:" + pass);
//	        	
//	        	String registeredUserName = (String) session.getAttribute("Username");
//	        	System.out.println("registeredUserName"+ registeredUserName);
//	        
//	        	
//       		 Travellers travl = dao.createTraveller(first,last,gen,email,dob,phone,add,pass, registeredUserName);
//       		 int travl_id = travl.getTravID();
//       		 System.out.println("travllers id:" +travl_id);
//       		 session.setAttribute("travl_id", travl_id);
////       		 System.out.println("checking trav: "+ travl.getAirlineusers());
//
//	        }

	        catch(HibernateException e) {
	        	System.out.print(e.getMessage());
	        }
	       
	        
	        
		
		return "verify-before-paying";
	}
	
	@GetMapping("/ViewAllPassengers.htm")
	public String viewAllPassengers(HttpServletRequest req, PassangerDAO dao, Travellers travl) throws Exception {
		
		HttpSession session = req.getSession();
		
		List<Travellers> travellers = dao.ListTravellers();
		session.setAttribute("travellers", travellers);
		
		return "view-all-passengers";
	}
	
}

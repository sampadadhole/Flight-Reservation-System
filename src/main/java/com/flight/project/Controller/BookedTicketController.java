package com.flight.project.Controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.Email;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.flight.project.DAO.BookedTicketDAO;
import com.flight.project.DAO.FlightDetailsDAO;
import com.flight.project.DAO.PassangerDAO;
import com.flight.project.POJO.BookedTickets;
import com.flight.project.POJO.FlightList;
import com.flight.project.POJO.Travellers;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import ErrorException.FException;

@Controller
public class BookedTicketController {

	@PostMapping("/bookedTickets.htm")
	public String getBookingPage(HttpServletRequest request, HttpServletResponse response) throws FException{
		
		System.out.println("paying 2");
		HttpSession session = request.getSession();
		int NoOfTraveller = (int) session.getAttribute("noOfTravllers");
		System.out.println("NoOfTraveller at getBokingPage: " + NoOfTraveller);
		FlightDetailsDAO fl_dao = new FlightDetailsDAO();
		
		
		try {
			for(int i =0;i<NoOfTraveller;i++) {
				int traveller_id = (int) session.getAttribute("travl_id"+i);
				System.out.println("travl_id at getBokingPage:" + traveller_id);
				PassangerDAO pass_dao = new PassangerDAO();
			BookedTicketDAO tic_dao = new BookedTicketDAO();
			FlightList flightlist = (FlightList) session.getAttribute("flightdetails");
			Travellers tv = pass_dao.searchTravellerbyId(traveller_id);
			tic_dao.bookTicket(tv, flightlist);
			int NoofseatsVail = flightlist.getNoSeatsAvaialable();
			System.out.println("NoofseatsVail" + NoofseatsVail);
			int noofpassengers = (int) session.getAttribute("noOfTravllers");
			System.out.print("update flight noofpassengers:" + noofpassengers);
			fl_dao.updateNoOfSeatsAvailable(flightlist, NoofseatsVail, NoofseatsVail-1);
			}
		
		}
		catch(Exception e) {
			throw new FException("Exception in BookedTicketContoller" + e.getMessage());
		}
		return "bookedTickets";
	}
	
	
	
	@PostMapping("/confirmation.htm")
	public String emailTicket(HttpServletRequest request, PassangerDAO pdao) throws FException{
		System.out.println("bookedticket");
		System.out.print("emailing ticket");
		try {
		String firstname="";
		String lastname="";
		HttpSession session = request.getSession();
		int NoOfTraveller = (int) session.getAttribute("noOfTravllers");
		System.out.println("NoOfTraveller at emailTicket: " + NoOfTraveller);
		Travellers[] trav = new Travellers[NoOfTraveller];
		for(int i=0;i<NoOfTraveller;i++) {
			int traveller_id = (int) session.getAttribute("travl_id"+i);
			System.out.println("trav_id in bookedTicket" + traveller_id);
			 trav[i] = pdao.searchTravellerbyId(traveller_id);
			 firstname = trav[i].getFirstName();
			 lastname = trav[i].getLastName();
		}
		
		String emial = request.getParameter("email");
		FlightList fl = (FlightList) session.getAttribute("flightdetails");
		String userName = "tript404@gmail.com";
		System.out.println("userName" +userName);
//        String password = "sampada1";
		String password = "nblbmmqslpeottuo";
        System.out.println("password"+password);
         
        String fromAddress="tript404@gmail.com";
        String toAddress =  "sampadadhole4@gmail.com";
        String HOST = "smtp.googlemail.com";
        int PORT = 465;
        boolean ssl_flag = true; 
        
		
			Email email = new SimpleEmail();
			email.setDebug(true);
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
//			email.setAuthenticator(new DefaultAuthenticator(userName,password ));
			email.setAuthentication(userName, password);
			email.setSSLOnConnect(true);
			email.setFrom(fromAddress);
			email.setSubject("Ticket Confirmation");
			for(int i =0;i<NoOfTraveller;i++) {
					email.setMsg("Hello,Passenger: " + firstname + " " + lastname + "\n"
					+ "Thank you for booking Ticket with us. Please find your flight details below " + "\n"
					+ "Flight Name: " + fl.getFlightName() + "\nFrom: " + fl.getFromplace()
					+ "\nDestination: " + fl.getToplace() + "\n" + "Departure Date: "
					+ fl.getDepartureDate() + "\nDeparture Time:" + fl.getDepartureTime() + "\n"
					+ "Destination Arrival Date: " + fl.getArrivalDate() + "\nDestination Arrival Time: "
					+ fl.getArrivalTime() +" \nNo of tickets booked: "+ NoOfTraveller +"\nThank you for booking with us");
			}
		
			email.addTo(emial);
			email.send();
			
			
		}
//		Email email = new SimpleEmail();
//		email.setHostName("smtp.gmail.com");
//		email.setSmtpPort(465);
//		email.setAuthenticator(new DefaultAuthenticator("sampadadhole646@gmail.com", "believeAS#1997"));
//		email.setSSLOnConnect(true);
//		try {
//			email.setFrom("sampadadhole646@gmail.com");
//			email.setSubject("Ticket Confirmation");
//			email.setMsg("Hello,Passenger:" + trav.getFirstName() + " " + trav.getLastName() + "\n"
//					+ "Thank you for booking Ticket with us. Please find your flight details below " + "\n"
//					+ "Flight Name" + fl.getFlightName() + " From " + fl.getFromplace()
//					+ " Destination " + fl.getToplace() + "\n" + "Departure Date"
//					+ fl.getDepartureDate() + "Departure Time :" + fl.getDepartureTime() + "\n"
//					+ "Destination Arrival Date" + fl.getArrivalDate() + "Destination Arrival Time"
//					+ fl.getArrivalTime());
//			email.addTo(emial);
//			email.send();
//		}
		catch(EmailException e) {
			e.printStackTrace();
			throw new FException("Exception in sending email"+e);
		}
		return "confirmation";
		
		}
	
	@GetMapping("/downloadTicket.pdf")
	public void Ticketdownload(HttpServletRequest request, HttpServletResponse response, PassangerDAO dao) throws FException, DocumentException, IOException {
		
		HttpSession session = request.getSession();
		
			try {
				int NoOfTraveller = (int) session.getAttribute("noOfTravllers");
				System.out.println("NoOfTraveller at downloadTicket: " + NoOfTraveller);
				for(int i=0;i<NoOfTraveller;i++) {
					int traveller_id = (int) session.getAttribute("travl_id"+i);
					Travellers travller = dao.searchTravellerbyId(traveller_id);
					FlightList flightDetail = (FlightList) session.getAttribute("flightdetails");
					
			
				response.setContentType("application/pdf");
				Document doc = new Document();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				PdfWriter.getInstance(doc, baos);
				doc.open();
				Paragraph title = new Paragraph("Thank you for booking with us. Here is your ticket booking");
				Paragraph name = new Paragraph("Passenger name:" + travller.getFirstName() + "" + travller.getLastName());
				Paragraph flight = new Paragraph("Flight Name:" + flightDetail.getFlightName() + " From: "
						+ flightDetail.getFromplace() + " Destination :" + flightDetail.getToplace());
				Paragraph deptDetails = new Paragraph(
						"Departure Date:" + flightDetail.getDepartureDate() + "Departure Time :" + flightDetail.getDepartureTime());
				Paragraph arrDetails = new Paragraph("Destination Arrival Date:" + flightDetail.getArrivalDate()
				+ "Destination Arrival Time:" + flightDetail.getArrivalTime());
				
				
				doc.add(title);
				doc.add(name);
				doc.add(flight);
				doc.add(deptDetails);
				doc.add(arrDetails);
				
				doc.close();

				ServletOutputStream out = response.getOutputStream();
				baos.writeTo(out);
				out.flush();
				}	
		}
			catch(FException e) {
				System.out.println("Could not download ticket" + e.getMessage());
			}
	}
	
	@GetMapping("/ViewAllbookedtickets.htm")
	public String viewAllPtickets(HttpServletRequest req, PassangerDAO dao, Travellers travl, BookedTicketDAO bdao) throws Exception {
		try {
			HttpSession session = req.getSession();
		
		List<BookedTickets> Allticketslist= bdao.ViewAllBooking();
		session.setAttribute("Allticketslist", Allticketslist);
		
		return "ViewAllbookedtickets";
		}
		catch(FException e) {
			throw new Exception("Exception at ViewAllbookedtickets" + e);
		}
		
	}
	
	
}

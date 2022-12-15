package com.flight.project.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.flight.project.DAO.FlightDetailsDAO;
import com.flight.project.DAO.ShowFlightsDAO;
import com.flight.project.POJO.FlightList;

@Controller
public class FlightListController {

	
	@GetMapping("/ShowFlightList.htm")
	public String showFlight(@ModelAttribute("flightsList") FlightList flightlist) {
		
		return "flightList";
	}
	
	@PostMapping("/ShowFlightList.htm")
	public String showFlights(@ModelAttribute("flightsList") FlightList flightlistpojo, HttpServletRequest request, FlightDetailsDAO dao,
			ShowFlightsDAO d) {
		
		try {
			HttpSession session = request.getSession();
			String From = request.getParameter("From");
			System.out.print(From);
			String To = request.getParameter("To");
			String dep_date = request.getParameter("dep_date");
			System.out.print("Departure"+dep_date);
			String trav_class = request.getParameter("trav_class");
			String arr_date = request.getParameter("arr_date");
//			String fid = request.getParameter("fid");
//			System.out.println("fid" + fid);
			
			List<String> flightslist = d.listFlights(From, To, dep_date, arr_date);
//			int seats = flightlistpojo.getNoSeatsAvaialable();
//			
////			int seats = d.getAvailableSeats(From, To, dep_date, arr_date);
//			System.out.println("no of avaialble seats:" + seats);
			
			int length = flightslist.size();
			System.out.println("length"+length);
			session.setAttribute("flightlist", flightslist);
			if(length == 0) {
				return "noflightsfound";
			}
			
//			session.setAttribute("AirID", flightlistpojo.getFlightID());
			
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return "flightList";
	}
}

package com.flight.project.Controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.flight.project.DAO.AirlineDAO;
import com.flight.project.DAO.FlightDetailsDAO;
import com.flight.project.POJO.FlightCompanies;
import com.flight.project.POJO.FlightList;

import ErrorException.FException;

@Controller
public class AdminAddnewFlightDetailsController {

	@GetMapping("/addNewFlight.htm")
	public String addnewFlight(@ModelAttribute("flightDetails") FlightList flight) throws FException{
		return "admin-addNewFlightDetails";
	}
	
	@PostMapping("/addNewFlight.htm")
	public String addnewFlightToDatabase(@ModelAttribute("flightDetails") FlightList flight, HttpServletRequest request) throws FException {

		try {
			FlightDetailsDAO dao = new FlightDetailsDAO();
			int flightId = flight.getFlightID();
			System.out.println("FLightID"+flightId);
			
			String flightName = flight.getFlightName();
			System.out.println("flightName"+flightName);
			
			String flightCompany = flight.getFlightCompany();
			System.out.println("flightCompany"+flightCompany);
			
			
			String fromplace = flight.getFromplace();
			System.out.println("fromplace"+fromplace);
			
			String plcae = request.getParameter("fromplace");
			System.out.println("plcae"+plcae);
			
			String toplace = flight.getToplace();
			System.out.println("toplace"+toplace);
			
			String departureTime = flight.getDepartureTime();
			System.out.println("departureTime"+departureTime);
			
			String arrivalTime = flight.getArrivalTime();
			System.out.println("arrivalTime"+arrivalTime);
			
			String departureDate = flight.getDepartureDate();
			System.out.println("departureDate"+departureDate);
			
			String arrivalDate = flight.getArrivalDate();
			System.out.println("arrivalDate"+arrivalDate);
			
			String travleClass = flight.getTravleClass();
			System.out.println("travleClass"+travleClass);
			
			int totalSeats = flight.getTotalSeats();
			System.out.println("totalSeats"+totalSeats);
			
			int NoSeatsAvaialable = flight.getNoSeatsAvaialable();
			System.out.println("NoSeatsAvaialable"+NoSeatsAvaialable);
			
			
			int price = flight.getPrice();
			System.out.println("price"+price);
			
			
			FlightList fli = dao.addNewFlight(flightId, flightName, fromplace, toplace, departureTime, arrivalTime, departureDate, arrivalDate, travleClass, totalSeats, NoSeatsAvaialable, price);
			
			
		}
		
		//		try {
//			FlightDetailsDAO dao = new FlightDetailsDAO();
//			int flightID = Integer.valueOf(request.getParameter("flightID"));
//			String flightName = request.getParameter("flightName");
//			String fromplace = request.getParameter("fromplace");
//			String toplace = request.getParameter("toplace");
//			String departureTime = request.getParameter("departureTime");
//			String arrivalTime = request.getParameter("arrivalTime");
//			String departureDate = request.getParameter("departureDate");
//			String arrivalDate = request.getParameter("arrivalDate");
//			String travleClass = request.getParameter("travleClass");
//			int totalSeats = Integer.valueOf(request.getParameter("totalSeats"));
//			int NoSeatsAvaialable = Integer.valueOf(request.getParameter("NoSeatsAvaialable"));
//			int price = Integer.valueOf(request.getParameter("price"));
//			
//			FlightList fli = dao.addNewFlight(flightID, flightName,fromplace,toplace, departureTime, arrivalTime,departureDate, arrivalDate,
//					travleClass,totalSeats,NoSeatsAvaialable,price);
//			
//			
//			
//		}
		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			return "error";
		}
		
		return "newflightadded";
		
	}
	
	@GetMapping("/ViewAllFLightDetails.htm")
	public String viewFlight(HttpServletRequest req, FlightDetailsDAO dao, FlightList fl) throws FException {
		try {
			HttpSession session = req.getSession();
		System.out.print("view All flights get");
		List<FlightList> fliList = dao.listAllFlights();
		session.setAttribute("fliList", fliList);
//		System.out.print(fliList);
		return "view-all-flight-details";
		}
		catch(Exception e) {
			System.out.println("Exception" + e);
			throw new FException("Exc"+e);
		}
		
	}
	
	@GetMapping("/EditFlightDetails.htm")
	public String EditFlightDetails(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String flightid = req.getParameter("fli_id");
		session.setAttribute("fli_id",flightid );
		System.out.println("fli_id:" + flightid);
		System.out.println("In edit flight details get mapping");
		return "edit-flight-details";
	}
	
	@PostMapping("/EditFlightDetails.htm")
//	@PostMapping("/successEditFlightdetails.htm")
	public String HandleEditFlightDetails(@ModelAttribute("Editflight") FlightList fc, HttpServletRequest req) throws FException {
		try {System.out.println("in try");
			String id = req.getParameter("flight_id");
			System.out.println("id:" + id);
			String updatedflightName = req.getParameter("updatedflightName");
			System.out.println("updatedflightName:" + updatedflightName);
			
			String updatedfromplace = req.getParameter("updatedfromplace");
			System.out.println("updatedfromplace:" + updatedfromplace);
			
			String updateddepartureDate = req.getParameter("updateddepartureDate");
			System.out.println("updateddepartureDate:" + updateddepartureDate);
			
			String updateddepartureTime = req.getParameter("updateddepartureTime");
			System.out.println("updateddepartureTime:" + updateddepartureTime);
			
			String updatedtoplace = req.getParameter("updatedtoplace");
			System.out.println("updatedtoplace:" + updatedtoplace);
			
			String updatedarrivalDate = req.getParameter("updatedarrivalDate");
			System.out.println("updatedarrivalDate:" + updatedarrivalDate);
			
			String updatedarrivalTime = req.getParameter("updatedarrivalTime");
			System.out.println("updatedarrivalTime:" + updatedarrivalTime);
			
			int updatedprice = Integer.valueOf(req.getParameter("updatedprice"));
			System.out.println("updatedprice:" + updatedprice);
			
			String updatedtravelclass = req.getParameter("updatedtravelclass");
			System.out.println("updatedtravelclass:" + updatedtravelclass);
			
			int updatedtotalSeats = Integer.valueOf(req.getParameter("updatedtotalSeats"));
			System.out.println("updatedtotalSeats:" + updatedtotalSeats);
			
			int FLightId = Integer.parseInt(id);
			System.out.println("FLightId:" + FLightId);
			
			HttpSession session = req.getSession();
			FlightDetailsDAO dao = new FlightDetailsDAO();
			FlightList f = dao.get(FLightId);
//			if(dao.checkIfDuplicatesFlightswhileUpdating(FLightId)==false) {
				System.out.println("in if flag");
				dao.updateFlightDetails( FLightId,  updatedflightName,  updatedfromplace,  updatedtoplace,  updateddepartureTime,  updatedarrivalTime,
						updateddepartureDate,  updatedarrivalDate,  updatedtravelclass,  updatedtotalSeats,  updatedprice);
				System.out.println("Flight updated successfully");
				return "edit-success";
//			}
//			else {
//				System.out.println("in else flag");
//				System.out.println("Flight Already present in the database");
//				return "err-page";
//			}
		}
			catch(HibernateException e) {
				System.out.println("Cant update flight");
				throw new FException("Cant update flight details: "+ e);
			}
		
		
	}
	
	@GetMapping("/delete-flight-details.htm")
	public String DeleteFlight(HttpServletRequest request) {
		String res = " ";
		try {
		FlightDetailsDAO dao = new FlightDetailsDAO();
		String id = request.getParameter("fli_id");
		id = id.replaceAll("[^\\d]+$", "");
		int FLightId = Integer.parseInt(id);
		System.out.print("Deleting flight:" + id);
//		System.out.println(FLightId);
		int out =  dao.DeleteFlight(FLightId);
		if(out == 1) {
			res = "flightDetails-deleted-success";
		}
		else {
			res = "delete-error";
		
		}
		}
		catch(Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		
		return res;
	}
}

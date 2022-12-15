package com.flight.project.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.flight.project.DAO.AirlineDAO;
import com.flight.project.POJO.FlightCompanies;

import ErrorException.FException;

@Controller
public class AdminAddFlightCompanyController {

	@GetMapping("/addFlightCompanies.htm")
	public String showadmin() throws FException{
		return "admin-addFlightCompanies";
	}
	
	@PostMapping("/addFlightCompanies.htm")
	public String addNewPlane(@ModelAttribute("flightCompanies") FlightCompanies fc, HttpServletRequest request, AirlineDAO airlinedao) throws FException{
		
		try {
			AirlineDAO dao = new AirlineDAO();
			String flightname = fc.getFightname();
			flightname = flightname.replaceAll("[^A-Za-z]+$", "");
			String flightcompany = fc.getFlightcompany();
			flightcompany = flightcompany.replaceAll("[^A-Za-z]+$", "");
			if(!airlinedao.checkIfDuplicates(flightname, flightcompany)) {
				dao.addFlightCompany(flightname, flightcompany);
				System.out.print("Airline comapny added successfully");
			}
			else {
				System.out.print("Airline comapny already exists");
				return "companyalredyexists";
			}			
		}

		catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			throw new FException("Exception while adding flight" + e);
		}
		
		
		return "airline-added-success";
		
	}
	
	@GetMapping("/ViewAllCompanies.htm")
	public String GetViewAllAirlineCompanies(FlightCompanies fc, HttpServletRequest req, AirlineDAO dao) throws FException {
		try {
			HttpSession session = req.getSession();
			List<FlightCompanies> companies = dao.listAllCompanies();
			session.setAttribute("companies", companies);
			return "view-all-airline-companies";
		}
		catch(Exception e) {
			System.out.println("Could not cancel Ticket " + e.getMessage());
			throw new FException("New Error" + e.getMessage());
		}
		
	}
	
	@GetMapping("/EditFlightCompany.htm")
	public String EditFlightCompanies(HttpServletRequest req) throws FException{
		try {
			HttpSession session = req.getSession();
			System.out.println("100");
			String admin_flight_id = req.getParameter("flight_id");
			session.setAttribute("flight_id",admin_flight_id );
			System.out.println("admin_flight_id" + admin_flight_id);
			return "EditFlightCompany";
		}
		catch(Exception e) {
			System.out.println("Exception: "+ e);
			throw new FException ("Exception: " +e);
		}
	}
	
	@PostMapping("/successEditFlightdetails.htm")
	public String PostViewAllAirlineCompanies(@ModelAttribute("EditCompany") FlightCompanies fc, HttpServletRequest req) throws FException{
		
		try {
			String id = req.getParameter("flight_id");
			int FLightId = Integer.parseInt(id);
			String name = req.getParameter("updated_company_name");
			String company = req.getParameter("updated_company_owner");
			HttpSession session = req.getSession();
			AirlineDAO dao = new AirlineDAO();
			FlightCompanies f = dao.get(FLightId);
			if(dao.checkIfDuplicateswhileUpdating(name)==false) {
				dao.updateCompany(FLightId,name,company);
			}
			else {
				System.out.println("Company Already present in the database");
				return "error";
			}
			
			req.setAttribute("f", f);
			return "edit-success";
			
			
		}
		catch(Exception e) {
			System.out.println("Exception ff: " + e.getMessage());
//			throw new Exception ("Exception: " +e);
			return "err-page";
		}
		
	
	}
	
	@GetMapping("/deleteFlight.htm")
	public String deleteAirline(HttpServletRequest request) throws FException{
		String res = " ";
		try {
		AirlineDAO dao = new AirlineDAO();
		String id = request.getParameter("flight_id");
		System.out.println(id);
//		id = id.replaceAll("[^\\d]+$", "");
		int FLightId = Integer.parseInt(id);
		System.out.println("flight id to be deleted: "+FLightId);
		int out =  dao.DeleteAirline(FLightId);
		System.out.println("out" + out);
		if(out == 1) {
			System.out.println("Flight deleted");
			return "deletedSuccess";
		}
		else {
			return "delete-error";
		
		}
		}
		catch(Exception e) {
			System.out.println("Exception" + e.getMessage());
			throw new FException("Exception while deleting flight company: "+ e);
		}
		
		
		
	}

}

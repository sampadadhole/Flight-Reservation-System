package com.flight.project.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.flight.project.DAO.AirlineUsersDAO;
import com.flight.project.DAO.BookedTicketDAO;
import com.flight.project.POJO.AirlineUsers;
import com.flight.project.POJO.BookedTickets;
import com.flight.project.POJO.Travellers;

import ErrorException.FException;







@Controller
public class HomeController {

	@GetMapping("/")
    public String home(){
        return "home";
    }
//	========================================= LOGIN =================================================
	@GetMapping("/login.htm")
	public String LogIn(@ModelAttribute("airlineUsers") AirlineUsers user,HttpServletRequest request, BindingResult result, SessionStatus status,
			AirlineUsersDAO userdao,Model model) {
//		HttpSession session = request.getSession();
		return "login";
	}
	@PostMapping("/login.htm")
	public String LoggedIn(HttpServletRequest request, AirlineUsersDAO userdao, AirlineUsers users) {
		HttpSession session = request.getSession();
		String Username = request.getParameter("Username");
		String Userpassword = request.getParameter("Userpassword");
		
		boolean adminflg = false;
		boolean userflg = false;
		try {

			adminflg = userdao.ValidateAdminDetails(Username, Userpassword);
			userflg = userdao.validateLoggedInUser(Username, Userpassword);
			int UIN = userdao.getUINLoggedIn(Username, Userpassword);
			System.out.println("UIN of lgged in user :"+ UIN);
			session.setAttribute("UINs", UIN);

		}
		catch (Exception e) {

			System.out.println("Exception: " + e.getMessage());

		}
		if (adminflg) {
			System.out.println("Login successful");
			session.setAttribute("Username", Username);
			int UIN = userdao.getUINLoggedIn(Username, Userpassword);
			session.setAttribute("UINs", UIN);
			
			return "admin-login-home";

		}
		else if (userflg) {

			System.out.println("Login successful");
			session.setAttribute("Username", Username);
			int UIN = userdao.getUINLoggedIn(Username, Userpassword);
			session.setAttribute("UINs", UIN);
			
			
			
//			int UserId = users.getUIN();
//			System.out.println("UserId" + UserId);
			return "User-login-Home";

		}
		else {
			return "err-page";
		}
		
		
		
//		return "";
	}
	
	
//	=============================Register=====================================

	
	@GetMapping("/register.htm")
	public String Register(ModelMap model, AirlineUsers user) {
		model.addAttribute("airlineUsers", user);

		return "register";
	} 
	
	@PostMapping("/register.htm")
	public String register(@ModelAttribute("airlineUsers") AirlineUsers user,HttpServletResponse response, AirlineUsersDAO dao, HttpServletRequest request) throws FException {
		
//		String action = request.getParameter("action");
//		if (action.equalsIgnoreCase("ajaxCheck")) {
//			PrintWriter out = response.getWriter();
//
//			if (dao.ifUserExists(request.getParameter("Username"))) {
//
//				JSONObject obj = new JSONObject();
//				obj.put("message", "Username already exists");
//				out.println(obj);
//
//			} else {
//				out.println("Username is available");
//			}
//			return null;
//		}
		
		HttpSession session = request.getSession();
		String Username = request.getParameter("Username");
		String Userpassword = request.getParameter("Userpassword");
		int UIN = Integer.valueOf(request.getParameter("UIN"));

		try {
			
			if(!dao.ifUserExists(Username)) {
				if(Userpassword.length() < 5) {
					System.out.println("User password constraint fails");
					return "err-page";
				}
				else {
					dao.addUser(Username, Userpassword, "user", UIN);
					
				System.out.println("New User has been added successfully");
				session.setAttribute("Username", Username);
				}
				
			}
			else {
				System.out.println("User already exists");
				return "err-page";
			}
			
		}
		catch(HibernateException e) {
			System.out.println("Exception:" + e.getMessage());
		}
		
		
		return "register-sucess";
	}
	
//	==================================Account =====================================
	
	@GetMapping("/account.htm")
	public String getAccount() {
		return "account";
	}
	
	
	@GetMapping("/account/ViewBookedFLightsHistory.htm")
	public String getBookedFlightDetails(HttpServletRequest request,  BookedTicketDAO bdao) throws FException {
		try {
					HttpSession session = request.getSession();
		List<BookedTickets> ticketslist= bdao.ViewAllBooking();
		session.setAttribute("ticketslist", ticketslist);
//		session.getAttribute("Allticketslist");
		System.out.println("ticketslist"+session.getAttribute("ticketslist"));
//		int travl_id = (int) request.getAttribute("travl_id");
		}
		catch(FException e) {
			throw new FException("Exception at getBookedFlightDetails:" + e);
		}

		
		
		return "ViewBookedFLightsHistory";
	}
	
	@GetMapping("/CancelBooking.htm")
	public String cancelBooking(HttpServletRequest request) throws FException {
		try {
			BookedTicketDAO dao = new BookedTicketDAO();
			String id = request.getParameter("tid");
			int tickId = Integer.parseInt(id);
			System.out.println("Ticket id to be cancelled" + id);
			int out =  dao.cancelTicket(tickId);
			System.out.println("out while cancelling flight" + out);
			if(out == 1) {
				System.out.println("ticket cancelled");
				return "ticketcancelled";
			}
			else {
				return "error";
			
			}
			
		}
		catch(Exception e) {
			throw new FException("Exception at cancelBooking:" + e);
		}
		
	}
	
	
	
//	==================================Sign out =====================================
	
	@GetMapping("/signout.htm")
	public String Signout(HttpServletRequest req) {
		HttpSession session = req.getSession();

		session.invalidate();
		
		return "signout";
	}

}

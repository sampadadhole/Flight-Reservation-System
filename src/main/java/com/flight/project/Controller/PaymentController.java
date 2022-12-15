package com.flight.project.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.flight.project.POJO.BookedTickets;
import com.flight.project.POJO.FlightList;

import ErrorException.FException;

@Controller
public class PaymentController {

	@GetMapping("/Payment.htm")
	public String getPage() throws FException{
		try {
			System.out.println("paying 1");
			return "paymentpage";
		}
		catch(Exception e)
		{
			throw new FException("Exception in get payment:" + e);
		}
		
		
	}
	
//	@PostMapping(value="/Payment.htm")
//	public String getPymentPage() throws FException{
//		try {
//			System.out.println("paying");
//			return "bookedTickets";
//		}
//		catch(Exception e)
//		{
//			throw new FException("Exception in post payment:" + e);
//		}
//		
//	}


	

}

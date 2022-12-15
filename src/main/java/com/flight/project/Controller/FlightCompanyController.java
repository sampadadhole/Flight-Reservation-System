package com.flight.project.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FlightCompanyController {

	@GetMapping("/ShowFlightDetails.htm")
    public String showflightcomapnies(){
        return "flight-companies";
    }
	
	
}

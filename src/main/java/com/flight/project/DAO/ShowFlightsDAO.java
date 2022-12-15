package com.flight.project.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

public class ShowFlightsDAO extends DataConnection{

	public List listFlights(String fromplace, String toplace, String departureDate, String arrivalDate) throws Exception {

		List<String> list = null;

		try {
			begin();
			Query q = getSession().createQuery("from FlightList where fromplace = :fromplace and toplace=:toplace and departureDate=:departureDate and arrivalDate=:arrivalDate");
			q.setString("fromplace", fromplace);
			q.setString("toplace", toplace);
			q.setString("departureDate", departureDate);
			q.setString("arrivalDate", arrivalDate);
			System.out.print(q);

			list = q.list();
			System.out.println(list);
			commit();
			return list;
		}

		catch (HibernateException e) {
			rollback();
			System.out.print("Flight couln't be found");
			throw new Exception("FLights couldn't be found");
		} finally {
			close();
		}
	

	}
	
	public int getAvailableSeats(String fromplace, String toplace, String departureDate, String arrivalDate) {
		int NoSeatsAvaialable=0;
		try {
			begin();
			Query q = getSession().createQuery("from FlightList where fromplace = :fromplace and toplace=:toplace and departureDate=:departureDate and arrivalDate=:arrivalDate ");
			q.setString("fromplace", fromplace);
			q.setString("toplace", toplace);
			q.setString("departureDate", departureDate);
			q.setString("arrivalDate", arrivalDate);
//			System.out.print(q);
			List<String> list = null;
			list = q.list();
			
			
//			Object obj = q.uniqueResult();
//			System.out.print(obj);
//			if(obj == null) return 0;
//			System.out.print(q.uniqueResult());
//			NoSeatsAvaialable=  (int) q.uniqueResult();
		}
		catch(HibernateException e) {
			rollback();
			System.out.println("cant find flightId");
		}
		finally {
			close();
		}

		return NoSeatsAvaialable;
	}
	
	
	
}

package com.flight.project.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.flight.project.POJO.FlightCompanies;
import com.flight.project.POJO.FlightList;

import ErrorException.FException;

@Component
public class FlightDetailsDAO extends DataConnection {

	
	public FlightList addNewFlight( int flightID, String flightName,String fromplace,String toplace,String departureTime, String arrivalTime, String departureDate, String arrivalDate,
			String travleClass,int totalSeats, int noSeatsAvaialable,int price) throws Exception {
		try {
			begin();
			FlightList f = new FlightList( flightID, flightName, fromplace, toplace, departureTime, arrivalTime,departureDate, arrivalDate,
					travleClass, totalSeats ,noSeatsAvaialable,price);
			getSession().save(f);
			commit();
			System.out.println("Added flight and available seats are" + f.getNoSeatsAvaialable());
			System.out.println("Flight formplace: " + f.getFromplace());
			System.out.println("Flight toplace: " + f.getToplace());
			
			return f;
		}
		catch(Exception e) {
			rollback();
			System.out.print(e.getMessage());
			throw new Exception("Exception addin gnew flight"+ e.getMessage());
		}
		finally {
			close();
		}
		

	}
	
	public List listFlights() throws Exception {
		try {
			
			begin();
			Query q = getSession().createQuery("from flightList");
			List list = q.list();
			commit();
			return list;
		}
		catch (HibernateException e) {
			rollback();
			System.out.print("Error while listing all flights");
			throw new Exception("Exception listing flight"+ e.getMessage());
		} finally {
			close();
		}
		
		
	}
	
	
	public List<FlightList> listAllFlights() throws Exception{
		List<FlightList> fliList = new ArrayList<FlightList>();
		try {
			begin();
			System.out.println("beginning list flights");
			Criteria crit = getSession().createCriteria(FlightList.class);
			fliList = crit.list();
			commit();
		
			return fliList;
		}
		catch(HibernateException e) {
			rollback();
			throw new Exception("couldnt get flights", e);
		}
		finally {
			close();
		}
	}
	public FlightList get(int flightiD) throws FException {
		try {
			begin();
			Query q = getSession().createQuery("from FlightList where fliiD=:fliiD");
			q.setInteger("fliiD", flightiD);
			FlightList fl = (FlightList) q.uniqueResult();
			commit();
			return fl;
		}
		catch(HibernateException e) {
			rollback();
			throw new FException("couldnt get flight details:" + e);
		}
		finally {
			close();
		}

	}
	
	public int DeleteFlight(int fliID) throws FException{
		try {
			
			
			FlightList fl = get(fliID);
			if(fl == null) {
				return 0;
			}
			System.out.println("flightiD detete"+fliID);
			begin();
			getSession().delete(fl);
			commit();
			getSession().flush();
			getSession().clear();
			return 1;
		}
		catch(HibernateException e) {
			rollback();
			throw new FException("couldnt be deleted flight");
		}
		finally {
			close();
		}
	}
	
	public boolean checkIfDuplicatesFlightswhileUpdating(int flightID) {
		try {
			begin();
			Query q = getSession().createQuery("From FlightList where fliID=:fliID");
			q.setInteger("fliID", flightID);
			Object obj = q.uniqueResult();
			if (obj == null) {
				return false;
			}
			
		}
		catch(HibernateException e) {
			rollback();
			System.out.print("Flight Company already exists");
		}
		finally {
			close();
		}
		return true;
	}

	public FlightList updateFlightDetails(int flightID, String flightName, String fromplace, String toplace, String departureTime, String arrivalTime,
			String departureDate, String arrivalDate, String travleClass, int totalSeats, int price) throws FException{
		try {
			begin();
			
			FlightList fc = 
                    (FlightList)getSession().get(FlightList.class, flightID); 
					fc.setFlightName(flightName);
					fc.setFromplace(fromplace);
					fc.setToplace(toplace);
					fc.setDepartureDate(departureDate);
					fc.setDepartureTime(departureTime);
					fc.setArrivalDate(arrivalDate);
					fc.setArrivalTime(arrivalTime);
					fc.setPrice(price);
					fc.setTravleClass(travleClass);
					fc.setTotalSeats(totalSeats);
					getSession().update(fc);
					commit();
					return fc;
		}

		catch(HibernateException e) {
			rollback();
			throw new FException(e.getMessage());
		}
		finally {
			close();
		}
	}
	
	public void updateNoOfSeatsAvailable(FlightList fl, int oldVtotal, int newtotal) throws FException{
		try {
			begin();
			int oldSeats = fl.getNoSeatsAvaialable();
			System.out.println("updateNoOfSeatsAvailable old seats:" + oldSeats);
			fl.setNoSeatsAvaialable(newtotal- (oldVtotal - oldSeats));
			System.out.println("No of seats available are: " + fl.getNoSeatsAvaialable());
			getSession().update(fl);
			commit();
		}
		catch(HibernateException e) {
			rollback();
			throw new FException("Could update flight"+ e);
		}
		finally {
			close();
		}
	}
	
}

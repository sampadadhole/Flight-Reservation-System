package com.flight.project.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.flight.project.POJO.BookedTickets;
import com.flight.project.POJO.FlightCompanies;
import com.flight.project.POJO.FlightList;
import com.flight.project.POJO.Travellers;

import ErrorException.FException;

public class BookedTicketDAO extends DataConnection{

	public BookedTickets bookTicket(Travellers travellers, FlightList flightlist) throws FException{
		
		try {
			begin();
			BookedTickets tic = new BookedTickets(travellers, flightlist);
			getSession().save(tic);
			commit();
			System.out.println("Ticket has been booked");
			
			return tic;
		}
		catch(HibernateException e) {
			rollback();
			System.out.print("Cant book ticket because" + e.getMessage());
			throw new FException("Exception while saving a booked ticket" + e.getMessage());
		}
		finally {
			close();
		}
		
		
	}
	
	public List<BookedTickets> ViewAllBooking() throws FException {
		try {
			begin();
//			Query q = getSession().createSQLQuery("SELECT f.flightName, t.TravID, trav.firstName from FlightList f, BookedTickets t, Travellers trav where f.flightID=t.fliID and t.TravID= trav.TravID");
			Query q = getSession().createQuery("FROM BookedTickets");
			List<BookedTickets> s = (List) q.list();
			
			commit();
			System.out.print("Booking list"+s);
			return s;
		
		}
		catch(Exception e) {
			throw new FException("Cant list all booking"+ e);
		}
		finally {
			close();
		}
	}
	
	public List TicketList() {
		List<BookedTickets> AllBookedtickets = new ArrayList<BookedTickets>();
		try {
			begin();
			Query q = getSession().createQuery("FROM BookedTicket");
			AllBookedtickets = q.list();
			commit();
			
		}
		catch(HibernateException e) {
			rollback();
			System.out.print("Cant list ticket because" + e.getMessage());
		}
		finally {
			close();
			
		}
		return AllBookedtickets;
	}
	public BookedTickets get(int ticketID) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from BookedTickets where ticketID=:ticketID");
			q.setInteger("ticketID", ticketID);
			BookedTickets fc = (BookedTickets) q.uniqueResult();
			commit();
			return fc;
		}
		catch(HibernateException e) {
			rollback();
			throw new Exception("couldnt get ticket:" + e.getMessage());
		}
		finally {
			close();
		}

	}
	
	public int cancelTicket(int TicketID) throws Exception {
		try {
			
			
			BookedTickets tc = get(TicketID);
			if(tc == null) {
				return 0;
			}
			System.out.println("cancelling ticket: "+TicketID);
			begin();
			getSession().delete(tc);
			commit();
			getSession().flush();
			getSession().clear();
			return 1;
		}
		catch(HibernateException e) {
			rollback();
			throw new Exception("couldnt be deleted");
		}
		finally {
			close();
		}
	}
	
	
}

package com.flight.project.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.flight.project.POJO.FlightCompanies;

public class AirlineDAO extends DataConnection{

	public FlightCompanies addFlightCompany(String fightname, String flightcompany) throws Exception {
		try {
			begin();
			FlightCompanies fc = new FlightCompanies(fightname, flightcompany);
			getSession().save(fc);
			commit();
			return fc;
		} catch (HibernateException e) {
			rollback();
			System.out.print(e.getMessage());
			throw new Exception("Flight compnay couldn't be added");
		} finally {
			close();
		}

	}
	
	public boolean checkIfDuplicates(String flightname, String flightcompany) {
		try {
			begin();
			Query q = getSession().createQuery("From FlightCompanies where flightname=:flightname and flightcompany=:flightcompany");
			q.setString("flightname", flightname);
			q.setString("flightcompany", flightcompany);
			Object obj = q.uniqueResult();
			if (obj == null) {
				return false;
			}
			
		}
		catch (HibernateException e) {
			rollback();
			System.out.print("Airline Company already exists");
		} finally {
			close();
		}

		return true;
	}
	
	public boolean checkIfDuplicateswhileUpdating(String flightname) {
		try {
			begin();
			Query q = getSession().createQuery("From FlightCompanies where flightname=:flightname");
			q.setString("flightname", flightname);
			Object obj = q.uniqueResult();
			if (obj == null) {
				return false;
			}
			
		}
		catch(HibernateException e) {
			rollback();
			System.out.print("Airline Company already exists");
		}
		finally {
			close();
		}
		return true;
	}
	
	public List<FlightCompanies> listAllCompanies() throws Exception{
		List<FlightCompanies> companies = new ArrayList<FlightCompanies>();
		try {
			begin();
			Criteria crit = getSession().createCriteria(FlightCompanies.class);
			companies = crit.list();
			commit();
			return companies;
		}
		catch(HibernateException e) {
			rollback();
			throw new Exception("couldnt get companies", e);
		}
		finally {
			close();
		}

	}
	
	public FlightCompanies get(int flightiD) throws Exception {
		try {
			begin();
			Query q = getSession().createQuery("from FlightCompanies where flightiD=:flightiD");
			q.setInteger("flightiD", flightiD);
			FlightCompanies fc = (FlightCompanies) q.uniqueResult();
			commit();
			return fc;
		}
		catch(HibernateException e) {
			rollback();
			throw new Exception("couldnt get flight:" + e.getMessage());
		}
		finally {
			close();
		}

	}
	public int DeleteAirline(int flightiD) throws Exception{
		try {
			
			
			FlightCompanies fc = get(flightiD);
			if(fc == null) {
				return 0;
			}
			System.out.println("flightiD detete: "+flightiD);
			begin();
			getSession().delete(fc);
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
	
	public FlightCompanies updateCompany(int flightiD, String flightname, String flightcompany) throws Exception{
		try {
//			begin();
//			Query q = getSession().createQuery("Update FlightCompanies set flightname=:flightname , flightcompany=:flightcompany where flightiD=:flightiD");
//			q.setString("flightname", flightname);
//			q.setString("flightcompany", flightcompany);
//			q.setInteger("flightiD", flightiD);
//			q.executeUpdate();
////			System.out.println("res" + res);
//			System.out.print(q);
//			FlightCompanies fc = (FlightCompanies) q.uniqueResult();
////			getSession().update(fc);
//			commit();
//			return fc;
			begin();
			
			FlightCompanies fc = 
                    (FlightCompanies)getSession().get(FlightCompanies.class, flightiD); 
					fc.setFightname(flightname);
					fc.setFlightcompany(flightcompany);
					getSession().update(fc);
					commit();
					return fc;
		}

		catch(HibernateException e) {
			rollback();
			throw new Exception(e.getMessage());
		}
		finally {
			close();
		}
	}

}

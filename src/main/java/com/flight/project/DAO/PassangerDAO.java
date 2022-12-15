package com.flight.project.DAO;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.flight.project.POJO.Travellers;

import ErrorException.FException;

public class PassangerDAO extends DataConnection{

	public Travellers createTraveller(String firstName, String lastName, String gender, String email, String dateOfBirth,
			String address, String passportNo, String phoneNum, String registeredUserName) throws Exception{
		try {
			begin();
			Travellers travellers = new Travellers(firstName, lastName, gender, email, dateOfBirth, address, passportNo,phoneNum, registeredUserName);
			getSession().save(travellers);
			
			commit();
			return travellers;
		}

		catch (HibernateException e) {
			rollback();
			System.out.print("Exception while creating new passenger: " + e.getMessage());
			throw new Exception("Exception while creating new passenger" + e.getMessage());
		} finally {
			close();
		}
		

	}
	
//	public int getUserIDfromUserName(String Username) {
//		try {
//			begin();
//			Query query = getSession().createQuery("From AirlineUsers where Username=:Username ");
//			query.setInteger("User_Id", User_Id);
//			passenger = (Travellers) query.uniqueResult();
//
//			commit();
//		} catch (HibernateException e) {
//			rollback();
//			// throw new AdException("Could not create flight", e);
//			throw new FException("Exception while searching passenger: " + e.getMessage());
//		} finally {
//			close();
//		}
//		return User_Id;
//	}
	
	
	
	public List ListTravellers() throws FException {
		try {
			begin();
			Query q = getSession().createQuery("From Travellers");
			List list = q.list();
			commit();
			return list;

		} catch (HibernateException e) {
			rollback();
			throw new FException("Exception while listing passenger: " + e);
		} finally {
			close();
		}
	}
	
	public Travellers searchTravellerbyId(int TravID) throws FException {
		Travellers passenger;
		try {
			begin();
			Query query = getSession().createQuery("From Travellers where TravID=:TravID ");
			query.setInteger("TravID", TravID);
			passenger = (Travellers) query.uniqueResult();

			commit();
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create flight", e);
			throw new FException("Exception while searching passenger: " + e.getMessage());
		} finally {
			close();
		}
		return passenger;
	}
	

	
}

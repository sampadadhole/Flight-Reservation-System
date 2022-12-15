package com.flight.project.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Component;

import com.flight.project.POJO.AirlineUsers;
import com.flight.project.POJO.Travellers;




@Component
public class AirlineUsersDAO  extends DataConnection{

	public void addUser(String Username, String Userpassword, String Userrole, int UIN) {
		
		
		try {
			begin();
			System.out.print(Username);
			System.out.print(Userpassword);
			System.out.print(getSession());
			AirlineUsers user = new AirlineUsers(Username, Userpassword, Userrole, UIN);
			getSession().save(user);
			commit();
			System.out.print("user: "+user);
			close();
			
		}
		catch(HibernateException e) {
			rollback();
			System.out.print(e.getMessage());
		}
		finally {
			close();
		}

	}
	
	public boolean validateLoggedInUser(String Username, String  Userpassword) {
		try {
			SQLQuery q = getSession().createSQLQuery("select * from airlineusers where Username=:Username and Userpassword=:Userpassword and Userrole='user'");
			q.setString("Username", Username);
			q.setString("Userpassword", Userpassword);
			Object obj = q.uniqueResult();
			if (obj == null) {
				return false;
			}
		}
		catch(HibernateException e) {
			rollback();
			System.out.print(e.getMessage());
			
		}
//		finally {
//			close();
//		}

		return true;
	}
	
	public boolean ValidateAdminDetails(String Username, String Userpassword) {
		try {

			SQLQuery q = getSession().createSQLQuery(
					"select * from airlineusers where Username=:Username and Userpassword=:Userpassword and Userrole='admin'");
			q.setString("Username", Username);
			q.setString("Userpassword", Userpassword);
			Object obj = q.uniqueResult();
			if (obj == null) {
				return false;
			}

		} catch (HibernateException e) {
			rollback();
			System.out.print("Error finding user");
		} finally {
			close();
		}

		return true;
	}
	public int getUINLoggedIn(String Username, String Userpassword) {
		SQLQuery q = getSession().createSQLQuery(
				"select UIN from airlineusers where Username=:Username and Userpassword=:Userpassword and Userrole='user'");
		q.setString("Username", Username);
		q.setString("Userpassword", Userpassword);
		Object obj = q.uniqueResult();
		if(obj == null) return 0;
		System.out.print(q.uniqueResult());
		return (int) q.uniqueResult();
		
		
	}
	
	public boolean ifUserExists(String Username) {
		try {
			begin();
			Query q = getSession().createQuery("FROM AirlineUsers where Username=:Username");
			q.setString("Username", Username);
			List result = q.list();
			commit();
			
			if(result.size() == 0) {
				return false;
			}
			
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			close();
		}
		return true;
	}
	
	

	}
	



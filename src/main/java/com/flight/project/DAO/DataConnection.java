package com.flight.project.DAO;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class DataConnection {

	
	protected DataConnection() {
    }
	private static final Logger log = Logger.getAnonymousLogger();

	@SuppressWarnings("deprecation")
	private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	private static final ThreadLocal thread = new ThreadLocal();
	
	 public static Session getSession()
	    {
	        Session session = (Session) DataConnection.thread.get();
	        
	        if (session == null)
	        {
	            session = sf.openSession();
	            DataConnection.thread.set(session);
	        }
	        return session;
	    }
	 
	 protected void begin() {
	        getSession().beginTransaction();
	    }

	    protected void commit() {
	        getSession().getTransaction().commit();
	    }
	    
	    protected void rollback() {
	        try {
	            getSession().getTransaction().rollback();
	        } catch (HibernateException e) {
	           System.out.print("Session error" +e.getMessage());
	        }
	        try {
	            getSession().close();
	        } catch (HibernateException e) {
	        	System.out.print("Session error" +e.getMessage());
	        
	        }
	        DataConnection.thread.set(null);
	    }

	    public static void close() {
	        getSession().close();
	        DataConnection.thread.set(null);
	    }
}

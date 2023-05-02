package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.entities.Person;
import com.app.util.HibernateUtilMySQL;
import com.app.util.HibernateUtilOracle;

public class Transfer {

	public static void main(String[] args) {
		
		SessionFactory oracleFactory = HibernateUtilOracle.getSessionFactory();
		Session oracleSession = HibernateUtilOracle.getSession();
		
		SessionFactory mysqlFactory = HibernateUtilMySQL.getSessionFactory();
		Session mysqlSession = HibernateUtilMySQL.getSession();
		
		try(oracleFactory;oracleSession;mysqlFactory;mysqlSession)
		{
			//get the data from oracle database
			Person person = oracleSession.get(Person.class, 1);
			
			//begin transaction for mysql db
			mysqlSession.beginTransaction();
			
			//Save theSave Object intObject mysqlFactory db
			mysqlSession.save(person);
			
			//commit the tx
			mysqlSession.getTransaction().commit();
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

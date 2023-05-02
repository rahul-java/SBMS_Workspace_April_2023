package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.app.entities.Person;
import com.app.util.HibernateUtilOracle;

public class Save {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtilOracle.getSessionFactory();
		Session session = HibernateUtilOracle.getSession();
		
		try(factory;session) {
			
			Person person = new Person();
			person.setP_name("Amit");
			person.setP_addres("Hryna");
			person.setP_balance(100000.0);
			
			session.beginTransaction();
			session.save(person);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

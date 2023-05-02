package com.app.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.app.entities.Person;

public class HibernateUtilMySQL {

	static SessionFactory factory;
	static {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate-mysql.cfg.xml");
		cfg.addAnnotatedClass(Person.class);
		factory = cfg.buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory() {
		return factory;
	}
	
	public static Session getSession()
	{
		return factory.openSession();
	}
}

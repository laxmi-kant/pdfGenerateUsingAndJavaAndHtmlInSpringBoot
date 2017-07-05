package com.base.config;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.base.model.Account;
import com.base.model.DateEvent;
import com.base.model.Event;
import com.base.model.Phone;

public class HibernateUtil2 {
	private static final SessionFactory concreteSessionFactory;
	static {
		try {
			Properties prop= new Properties();
			prop.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			prop.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/Test");
			prop.setProperty("hibernate.connection.username", "root");
			prop.setProperty("hibernate.connection.password", "root");
			prop.setProperty("dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
			prop.setProperty("hibernate.hbm2ddl.auto", "create");
			prop.setProperty("hibernate.show_sql", "true");
//			prop.setProperty("hiernate.format_sql", "false");
			concreteSessionFactory = new Configuration()
		   .addPackage("com.base.model")
				   .addProperties(prop).addAnnotatedClass(Event.class).addAnnotatedClass(Account.class)
				   .addAnnotatedClass(Phone.class)
				   .addAnnotatedClass(DateEvent.class)
				   .buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static Session getSession()
			throws HibernateException {
		return concreteSessionFactory.openSession();
	}
	
}

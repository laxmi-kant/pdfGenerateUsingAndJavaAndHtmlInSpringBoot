package com.base.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.config.HibernateUtil2;
import com.base.model.DateEvent;

public class MappingDateTimeValues {

	public static void main(String[] args) {
		Session session=HibernateUtil2.getSession();
		DateEvent dateEvent=new DateEvent();
	Date d =new Date();
//	dateEvent.setId(2L);
	dateEvent.setTime(new Date());
	dateEvent.setTimestamp(d);
	dateEvent.setTimestamp1(d);
	DateEvent dateEvent1=new DateEvent();
	Date d2 =new Date();
	dateEvent1.setTime(new Date());
	dateEvent1.setTimestamp(d2);
	dateEvent1.setTimestamp1(d2);
	Transaction tx = session.beginTransaction();
	
	try{
	session.save(dateEvent);
	session.save(dateEvent1);
	 tx.commit();
//	session.flush();
	System.out.println("Data saved successfully"+dateEvent.getTime());
	}catch(Exception e){
		System.out.println(e);
//		tx.rollback();
	}finally{
		session.close();
	}
	}

}

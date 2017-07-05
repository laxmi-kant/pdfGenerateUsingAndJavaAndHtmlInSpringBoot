package com.base.test;

import java.time.Period;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.config.HibernateUtil2;
import com.base.model.DateEvent;
import com.base.model.Event;

public class AttributeConverterImmutableTypes {

	public static void main(String[] args) {
		Session session=HibernateUtil2.getSession();

	Transaction tx = session.beginTransaction();
	
	try{

	 tx.commit();
	 Event event = session.createQuery( "from Event", Event.class ).getSingleResult();
	 event.setSpan(Period
	     .ofYears( 3 )
	     .plusMonths( 2 )
	     .plusDays( 1 )
	 );
	System.out.println("Data saved successfully");
	}catch(Exception e){
		System.out.println(e);
		tx.rollback();
	}finally{
		session.close();
	}
	}



}

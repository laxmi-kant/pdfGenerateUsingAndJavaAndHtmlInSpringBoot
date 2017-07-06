package com.base.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.config.HibernateUtil2;
import com.base.generated.Person;
import com.base.generated.Event;

public class GeneratedTest {

	public static void main(String[] args) {
		Session session=HibernateUtil2.getSession();

		Transaction tx = session.beginTransaction();
		CurrentUser.INSTANCE.logIn( "Alice" );
		Person p =new Person();
		p.setId(2L);
		p.setFirstName("Laxmi");
		p.setLastName("yadav");
		p.setMiddleName1(" ");
		p.setMiddleName2("kant");
		p.setMiddleName3("s");
		p.setMiddleName4("l");
		p.setMiddleName5("k");
		Event event=new Event();
		
		try{
			session.save(p);
			session.save(event);
			session.flush();
			
		 tx.commit();
		
		System.out.println("Data saved successfully");
		CurrentUser.INSTANCE.logOut();
		}catch(Exception e){
			System.out.println(e);
			tx.rollback();
		}finally{
			session.close();
		}

	}

}

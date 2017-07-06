package com.base.test;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.config.HibernateUtil2;
import com.base.sqlQuotedIdentifiers.GlobalQuoting;
import com.base.sqlQuotedIdentifiers.HibernatelegacyQuoting;
import com.base.sqlQuotedIdentifiers.JPAquoting;

public class QuotingTest {

	public static void main(String[] args) {
		Session session=HibernateUtil2.getSession();

		Transaction tx = session.beginTransaction();
		GlobalQuoting globalQuoting=new GlobalQuoting();
		globalQuoting.setId(0L);
		globalQuoting.setName("lk");
        globalQuoting.setNumber("1234");
        HibernatelegacyQuoting quoting=new HibernatelegacyQuoting();
        quoting.setId(0L);
        quoting.setName("lk");
        quoting.setNumber("1234");
       JPAquoting jpAquoting=new JPAquoting();
       jpAquoting.setId(0L);
       jpAquoting.setName("lk");
       jpAquoting.setNumber("1234");
		try{
			session.save(jpAquoting);
			session.save(globalQuoting);
			session.save(quoting);
		 tx.commit();
		
		System.out.println("Data saved successfully");
		}catch(Exception e){
			System.out.println(e);
			tx.rollback();
		}finally{
			session.close();
		}
		}

	

}

package com.base.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.config.HibernateUtil2;
import com.base.model.Account;
import com.base.model.Money;

public class AttributeConverterMutableType {
public static void main(String[] args){
	Session session=HibernateUtil2.getSession();
	Transaction tx = session.beginTransaction();
	Account account=new Account();
	account.setId(5L);
	account.setBalance(new Money(300));
	account.setOwner("Ashishss ");
	try{
		session.save(account);
		
//		Account accounts = session.find( Account.class, 1L );
//		account.getBalance().setCents( 150 * 100L );
//		session.persist( accounts );
	 tx.commit();
	 
//	System.out.println("Data saved successfully"+accounts.getOwner()+"  "+accounts.getBalance()+"   "+accounts.getId());
	}catch(Exception e){
		System.out.println(e);
//		tx.rollback();
	}finally{
		session.close();
	}

}
}

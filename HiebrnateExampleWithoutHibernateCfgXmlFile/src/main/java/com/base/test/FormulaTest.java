package com.base.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.base.FormulaAnnotation.Account;
import com.base.FormulaAnnotation.AccountFilter;
import com.base.FormulaAnnotation.AccountType;
import com.base.FormulaAnnotation.Client;
import com.base.config.HibernateUtil2;

public class FormulaTest {

	public static void main(String[] args) {
		Session session=HibernateUtil2.getSession();
		Transaction tx= session.beginTransaction();
		try{
			Client client = new Client();
		    client.setId( 1L );
		    client.setName( "John Doe" );
		    session.persist( client );

		    AccountFilter account1 = new AccountFilter( );
		    account1.setId( 1L );
		    account1.setType( AccountType.CREDIT );
		    account1.setAmount( 5000d );
		    account1.setRate( 1.25 / 100 );
		    account1.setActive( true );
		    account1.setClient( client );
		    client.getAccounts().add( account1 );
		    session.persist( account1 );

		    AccountFilter account2 = new AccountFilter( );
		    account2.setId( 2L );
		    account2.setType( AccountType.DEBIT );
		    account2.setAmount( 0d );
		    account2.setRate( 1.05 / 100 );
		    account2.setActive( false );
		    account2.setClient( client );
		    client.getAccounts().add( account2 );
		    session.persist( account2 );

		    AccountFilter account3 = new AccountFilter( );
		    account3.setType( AccountType.DEBIT );
		    account3.setId( 3L );
		    account3.setAmount( 250d );
		    account3.setRate( 1.05 / 100 );
		    account3.setActive( true );
		    account3.setClient( client );
		    client.getAccounts().add( account3 );
		    session.persist( account3 );
		    
		    List<Account> accounts = session.createQuery(
		            "select a from AccountFilter a", Account.class)
		        .getResultList();
//		        assertEquals( 2, accounts.size());
		System.out.println("interest is "+accounts.size());
			tx.commit();
		}catch(Exception e){
			System.out.println(e);
		}
		finally{
			session.close();
		}

	}

}

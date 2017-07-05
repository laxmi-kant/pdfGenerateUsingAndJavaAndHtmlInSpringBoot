package com.base.test;

import org.hibernate.Session;

import com.base.config.HibernateUtil2;
import com.base.model.Phone;
import com.base.model.PhoneType;

public class Test {
public static void main(String[] args){
	Session session=HibernateUtil2.getSession();
	Phone phone = new Phone( );
	phone.setId( 1L );
	phone.setNumber( "123-456-78990" );
	phone.setType( PhoneType.MOBILE );
	session.update(phone);
}
}

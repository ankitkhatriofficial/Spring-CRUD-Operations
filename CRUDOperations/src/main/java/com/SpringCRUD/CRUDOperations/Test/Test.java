package com.SpringCRUD.CRUDOperations.Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.SpringCRUD.CRUDOperations.entity.Customer;

public class Test {

	public void test() {
	
		SessionFactory factory = new Configuration()
								.configure("customer.cfg.xml")
								.buildSessionFactory();
	
		Session session = factory.getCurrentSession();
		
		Customer  c1 = new Customer("Ankit","Khatri","email@email.com");
		
		session.beginTransaction();
		
		session.save(c1);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.test();
	}
	
}

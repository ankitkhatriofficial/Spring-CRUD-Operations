package com.SpringCRUD.CRUDOperations.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.SpringCRUD.CRUDOperations.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory factory;
	
	@Override
	public List<Customer> getCustomers() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query<Customer> query = session.createQuery("from Customer",Customer.class);
		List<Customer> theCustomersList = query.list();
		session.getTransaction().commit();
		return theCustomersList;
	}

	@Override
	public Customer getCustomer(int customerID) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Customer theCustomer = session.load(Customer.class, customerID);
		
		/* Why this System.out.println() line creating an error ??? */
		System.out.println(theCustomer);
		
		session.getTransaction().commit();
		return theCustomer;
	}

	@Override
	public void saveCustomer(Customer customerObj) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(customerObj);
		session.getTransaction().commit();
	}

	@Override
	public void removeCustomer(Customer customerObj) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.delete(customerObj);
		session.getTransaction().commit();
	}

}

package com.SpringCRUD.CRUDOperations.dao;

import java.util.List;

import com.SpringCRUD.CRUDOperations.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public Customer getCustomer(int customerID);

	public void saveCustomer(Customer customerObj);
	
	public void removeCustomer(Customer customerObj);
}

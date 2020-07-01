package com.SpringCRUD.CRUDOperations.service;

import java.util.List;

import com.SpringCRUD.CRUDOperations.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int customerID);
	
	public void saveCustomer(Customer customerObj);
	
	public void removeCustomer(int customerID);
}

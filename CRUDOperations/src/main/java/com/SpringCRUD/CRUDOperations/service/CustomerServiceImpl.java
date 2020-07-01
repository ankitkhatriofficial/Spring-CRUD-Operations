package com.SpringCRUD.CRUDOperations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringCRUD.CRUDOperations.dao.CustomerDAO;
import com.SpringCRUD.CRUDOperations.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	public Customer getCustomer(int customerID) {
		return customerDAO.getCustomer(customerID);
	}

	@Override
	public void saveCustomer(Customer customerObj) {
		customerDAO.saveCustomer(customerObj);
	}

	@Override
	public void removeCustomer(int customerID) {
		Customer theCustomer = customerDAO.getCustomer(customerID);
		customerDAO.removeCustomer(theCustomer);
	}

}

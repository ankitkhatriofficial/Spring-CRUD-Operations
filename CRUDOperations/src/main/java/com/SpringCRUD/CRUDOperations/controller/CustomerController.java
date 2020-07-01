package com.SpringCRUD.CRUDOperations.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SpringCRUD.CRUDOperations.entity.Customer;
import com.SpringCRUD.CRUDOperations.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/list")
	public String showCustomersList(Model model) {
		model.addAttribute("customers",customerService.getCustomers());		
		return "customers.jsp";
	}
	
	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		model.addAttribute("customer",new Customer());
		return "newCustomerForm.jsp";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
		customerService.saveCustomer(theCustomer);
		return "redirect:/customers/list";
	}
	
	@GetMapping("/updateCustomer")
	public String updateCustomer(@RequestParam("customerId") int id, Model model) {
		Customer theCustomer = customerService.getCustomer(id);
		model.addAttribute("customer",theCustomer); 
		return "newCustomerForm.jsp"; 
	}
	
	@GetMapping("/removeCustomer")
	public String removeCustomer(@RequestParam("customerId") int id, Model model ) {
		customerService.removeCustomer(id);
		return "redirect:/customers/list";
	}
}

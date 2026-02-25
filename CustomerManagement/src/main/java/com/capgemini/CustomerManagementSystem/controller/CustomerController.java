package com.capgemini.CustomerManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.capgemini.CustomerManagementSystem.model.Customer;
import com.capgemini.CustomerManagementSystem.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public String getEmployeeDetails(Model model) {
		List<Customer> customer = customerService.getAllCustomer();
		model.addAttribute("customers",customer);
		return "customer-list";
		
	}
	
	@GetMapping("/addCustomer")
	public String showAddCustomerForm(Model model) {
		model.addAttribute("customer",new Customer());
		return "add-customer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customers";
	}
	

}

package com.capgemini.CustomerManagementSystem.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.CustomerManagementSystem.model.Customer;
import com.capgemini.CustomerManagementSystem.repository.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}


}

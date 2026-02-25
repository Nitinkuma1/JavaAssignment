package com.capgemini.CustomerManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.CustomerManagementSystem.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

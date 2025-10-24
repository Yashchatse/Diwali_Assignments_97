package com.example.Product_Management.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Product_Management.model.Customer;
import com.example.Product_Management.repository.CustomerRepository;

@Service
public class CustomerService {
	
@Autowired CustomerRepository customerRepository;


public Customer createCustomer(Customer customer) {
    if (customerRepository.existsByEmail(customer.getEmail())) {
        throw new RuntimeException("Email already exists"); 
    }
   
    return customerRepository.save(customer);
}



public Optional<Customer> getCustomerById(int id) {
    return customerRepository.findById(id);
}

public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
}

public Customer updateCustomer(int id, Customer customerDetails) {
    Customer customer = customerRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Customer not found"));


    if (!customer.getEmail().equals(customerDetails.getEmail()) &&
        customerRepository.existsByEmail(customerDetails.getEmail())) {
        throw new RuntimeException("Email already in use");
    }

    customer.setFirstName(customerDetails.getFirstName());
    customer.setLastName(customerDetails.getLastName());
    customer.setEmail(customerDetails.getEmail());
    customer.setAddress(customerDetails.getAddress());
    customer.setPhoneNumber(customerDetails.getPhoneNumber());

   

    return customerRepository.save(customer);
}

public void deleteCustomer(int id) {
    customerRepository.deleteById(id);
}



	
}

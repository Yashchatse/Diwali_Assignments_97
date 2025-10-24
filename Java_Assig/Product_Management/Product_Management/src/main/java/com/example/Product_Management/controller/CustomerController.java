package com.example.Product_Management.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Product_Management.service.CustomerService;
import com.example.Product_Management.model.Customer;

@RestController
@RequestMapping("/api/Customers")
public class CustomerController {

	 @Autowired
	    private CustomerService customerService;
	 
	 @PostMapping
	 public ResponseEntity<Customer> createCust(@RequestBody Customer customer){
		 Customer saveCustomer = customerService.createCustomer(customer);
		 return ResponseEntity.ok(saveCustomer);
	 }
	 @GetMapping("/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
	        Optional<Customer> customer = customerService.getCustomerById(id);
	        return customer.map(ResponseEntity::ok)
	                       .orElse(ResponseEntity.notFound().build());
	    }

	    @GetMapping
	    public ResponseEntity<List<Customer>> getAllCustomers() {
	        return ResponseEntity.ok(customerService.getAllCustomers());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customerDetails) {
	        Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
	        return ResponseEntity.ok(updatedCustomer);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
	        customerService.deleteCustomer(id);
	        return ResponseEntity.noContent().build();
	    }

}

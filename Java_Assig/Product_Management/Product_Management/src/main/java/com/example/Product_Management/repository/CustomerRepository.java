package com.example.Product_Management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Product_Management.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	 Optional<Customer> findByEmail(String email);
	    boolean existsByEmail(String email);

}

package com.example.Product_Management.model;

import jakarta.persistence.*;


@Entity

@Table(name="Customers221")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String address;
	private double phoneNumber;
	
	
	public Customer() {
		super();
	}


	public Customer(int id, String firstName, String lastName, String email, String password, String address,
			double phoneNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}


	
	
	
}

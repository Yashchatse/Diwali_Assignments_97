package com.demo.beans;

public class Employee {
	private int empNo;
	private String name;
	private String mobile;
	
	public Employee() {
		super();
	}
	public Employee(int empNo, String name , String mobile) {
		this.empNo = empNo;
		this.mobile = mobile;
		this.name = name;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", name=" + name + ", mobile=" + mobile + "]";
	}
	
		
	
}

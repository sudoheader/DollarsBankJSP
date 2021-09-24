package com.dollarsbank.model;

import com.dollarsbank.dao.CustomerDaoImpl;

import java.time.LocalDateTime;

public class Customer extends SavingsAccount {

	private String customer;
	private String address;
	private String contact;
	CustomerDaoImpl cdi = new CustomerDaoImpl();
	LocalDateTime ldt = LocalDateTime.now();

	public Customer(String customer, String address, String contact, String userId, String password, double amount) {
		super();
		this.customer = customer;
		this.address = address;
		this.contact = contact;

		setUserId(userId);
		setPassword(password);
		setBalance(amount);
		ldt = LocalDateTime.now();
		if(cdi.getHistory(getUserId()).size() == 0) {
			addToHistory("Initial Deposit Amount in account ["+userId+"]\n"
					+ "Balance - " + amount + " as of "  +ldt.getDayOfWeek()+" "
					+ ldt.getMonth()+" "+ldt.getDayOfMonth()+" "+ ldt.getHour()+":"+ldt.getMinute()+":"+ldt.getSecond()
					+" " +" "+ldt.getYear());
		}
	}
	public Customer() {
		super(); 
	}
	
	public String toString() {
		return "Customer [name=" + customer + ", address=" + address + ", contact=" + contact
				+ "]"+ "{Account info [[ UserId= " + getUserId() + " " + "UserPass= " + getPassword()+ "]]  }";
	}
	
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
}
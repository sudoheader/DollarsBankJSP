package com.dollarsbank.dao;

import com.dollarsbank.model.Customer;

import java.util.List;

public interface CustomerDao {

	int updateBalance(String userId, double balance) ;
	int delete(int id);
	int save(Customer e);
	void saveHistory(String userId, String historyMessage);
	Customer getCustomerById(int id);
	List<String> getHistory(String userId);
	List<Customer> getAllAccounts();
}

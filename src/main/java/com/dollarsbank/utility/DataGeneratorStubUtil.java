package com.dollarsbank.utility;

import com.dollarsbank.model.Customer;

import java.util.List;

public class DataGeneratorStubUtil {

	public static FileStorageUtility fsu = new FileStorageUtility();
	
	public boolean generateStub(Customer c) {
		String top =
				  "Bank Stub\n"
				+ "ID: " + c.getUserId()+"\n"
				+ "Name: " + c.getCustomer() + "\n"
				+ "Balance: " + c.getBalance() + "\n"
				+ "Address: " + c.getAddress()+ "\n"
			    + "Contact: " + c.getContact()+ "\n\n"
				+ "Recent Transactions\n";

		String message = transactionHistory(c.getHistory());
		
		fsu.saveFile(c.getUserId(),top + message);
		
		return false;
	}

	public String transactionHistory(List<String> history) {
		String transactionHistory = "";

		for (String string : history) {
			transactionHistory += string.replace("\n", "") + "\n";
		}

		transactionHistory += "\n";
		return transactionHistory;
	}
}

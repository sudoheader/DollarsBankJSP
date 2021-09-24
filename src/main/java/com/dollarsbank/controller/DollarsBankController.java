package com.dollarsbank.controller;

import com.dollarsbank.dao.CustomerDaoImpl;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ConsolePrinterUtility;
import com.dollarsbank.utility.DataGeneratorStubUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DollarsBankController {

	CustomerDaoImpl cdi = new CustomerDaoImpl();

	static {
		try {
			CustomerDaoImpl cdi = new CustomerDaoImpl();
			cdi.save(
					new Customer("Bob", "1000 Brand Blvd", "100-123-4567",
					"bob", "bobpassword" , 4000));
			cdi.save(
					new Customer("John", "9000 Cloverfield lane", "100-123-0987",
					"john", "johnpassword", 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	int option = 0;
	public static ConsolePrinterUtility cpu = new ConsolePrinterUtility();
	public static DataGeneratorStubUtil dgsu = new DataGeneratorStubUtil();
	Scanner scan = new Scanner(System.in);

	public Boolean run() {

		cpu.menu();
		option = 0;
		try {
			option = scan.nextInt();
			scan.nextLine();
		} catch(InputMismatchException mis) {
			scan.nextLine();
			cpu.notAnOption();
		}
		
		switch (option) {
			case 1:
				createAccount();
				scan.reset();
				break;
			case 2:
				login();
				scan.reset();
				break;
			case 3:
				exit();
				break;
			default:
				break;
		}
		
		System.out.flush();

		return true;
	}

	public void createAccount() {
		String name = "";
		String address = "";
		String contactNumber = "";
		String userId = "";
		String password = "";
		double initalDeposit = 0;

		try {
			System.out.println("Customer Name: ");

			scan.hasNextLine();
			name = scan.nextLine();
			System.out.println("Customer Addresss: ");

			address = scan.nextLine();
			System.out.println("Customer Contact Number: ");

			contactNumber = scan.nextLine();
			System.out.println("User Id: ");
			userId = scan.nextLine();
			System.out.println("Password: 8 Characters with Lower, Upper & special");
			password = scan.nextLine();

			if(passCheck(password)) {
				
				System.out.println("Password looks good!");
				System.out.println("Initial Deposit Amount: ");
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}

				initalDeposit = scan.nextDouble();
				scan.nextLine();
				cdi.save(new Customer(name, address, contactNumber, userId, password, initalDeposit));
			}

			else {
				System.out.println("Password needs to be 8 Characters with Lower, Upper & special");
			}
		} catch (InputMismatchException ime) {

		}
	}

	public void login() {
		List<Customer> list = cdi.getAllAccounts();
		String userId = "";
		String password = "";
		boolean logout=false;
		int iterator = 0;
		cpu.credentials();
		System.out.println("User Id: ");
		userId = scan.nextLine();
		System.out.println("Password: ");
		password = scan.nextLine();

		for (Customer customer : list) {
			try {
				if (customer.getUserId().equalsIgnoreCase(userId) && customer.getPassword().equalsIgnoreCase(password)) {
					System.out.println();
					loginSuccess(customer.getUserId(),iterator);
					logout = true;
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			iterator++;
		}
		if(logout) {
			
		}
		else {
			cpu.invalidCreds();
			System.out.println();
			login();
		}
	}

	public void loginSuccess(String userId, int iterator) {

		List<Customer> list = cdi.getAllAccounts();
		boolean signOut = false;
		double amount = 0;
		int loginOption = 0;
		list.get(iterator).toString();

		while(!signOut) {
			
			cpu.loggedIn();
			try {
				loginOption = scan.nextInt();
				scan.nextLine();

				switch (loginOption) {
					case 1:
						System.out.println("Enter deposit amount :");
						
							amount = scan.nextDouble();
							scan.nextLine();
							if(amount >= 0) {
								list.get(iterator).deposit(amount);
								cdi.updateBalance(userId, list.get(iterator).getBalance());
								System.out.println("Deposit successful, your current balance is: " + list.get(iterator).getBalance());
							}
							else {
								System.out.println("Invalid input, please insert amount greater than 0");
							}
						break;
					case 2:
						System.out.println("Enter withdrawal amount :");
						
							amount = scan.nextDouble();
							scan.nextLine();
							if(amount >= 0 && amount <= list.get(iterator).getBalance()) {
								list.get(iterator).withdraw(amount);
								cdi.updateBalance(userId, list.get(iterator).getBalance());
								System.out.println("Withdraw successful, your current balance is: " + list.get(iterator).getBalance());
								
							}
							else {
								System.out.println("Invalid input, please insert upto funds amount\n"
										+ "your total funds =[" + list.get(iterator).getBalance());
							}
						break;
					case 3:
						int transferCount = 0;
						int listPos = 0;
						boolean transferable = false;
						String userId2 = "";
						System.out.println("Enter user id to transfer to: ");
						
							userId2 = scan.nextLine().toLowerCase();
							for (Customer customer : list) {
								if(customer.getUserId().equalsIgnoreCase(userId2)) {
									transferable = true;
									listPos = transferCount ;
								}
								transferCount++;
							}
							if(!transferable) {
								System.out.println("There is no user with that id");
								break;
							}
							System.out.println("Enter transfer amount to " + userId2);
							amount = scan.nextDouble();
							scan.nextLine();
							if(amount >= 0 && amount <= list.get(iterator).getBalance()) {
								list.get(listPos).deposit(list.get(iterator).transfer(amount,list.get(listPos).getUserId()));
								cdi.updateBalance(list.get(iterator).getUserId(), list.get(iterator).getBalance());
								cdi.updateBalance(list.get(listPos).getUserId(), list.get(listPos).getBalance());
								System.out.println("Transfer successful, your current balance is: " + list.get(iterator).getBalance());
								
							}
							else {
								System.out.println("Invalid input, please insert upto funds amount\n"
										+ "your total funds =[" + list.get(iterator).getBalance());
							}
						break;
					case 4:
						System.out.println();
						list.get(iterator).printHistory();
						System.out.println();
						break;
					case 5:
						cpu.displayInfo();
//						dgsu.generateStub(list.get(iterator));
						break;
					case 6:
						signOut = true;
						break;
					default:
						break;
				}
			} catch (InputMismatchException e) {
				scan.nextLine();
				cpu.notAnOption();
			}
		}
	}

	public void transaction(int userId) {
		cdi.getCustomerById(userId);
	}

	private boolean passCheck(String password) {
		int test = 0;
		if(password.length() >= 8) // more than 8
			test++;
		if(password.matches("(?=.*[0-9]).*")) // numbers
			test++;
		if(password.matches("(?=.*[a-z]).*")) // lowercase letters
			test++;
		if(password.matches("(?=.*[A-Z]).*")) // upper case letters
			test++;
		if(password.matches("(?=.*[~!@#$%^&*()_-]).*")) // special characters
			test++;
		if(test == 5) // add up test
			return true;
		else
			return false;
	}
	public void exit() {
		System.exit(0);
	}
}

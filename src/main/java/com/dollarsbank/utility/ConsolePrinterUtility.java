package com.dollarsbank.utility;

import com.dollarsbank.model.Customer;

public class ConsolePrinterUtility {

    ColorsUtility color = new ColorsUtility();
    Customer c = new Customer();

    static String welcome = "DOLLARSBANK Welcomes You!";
    static String enterDetails = "Enter Details For New Account";
    static String enterLogin = "Enter Login Details";
    static String welcomeCustomer = "WELCOME Customer!!!";
    static String recentTransactions = "5 Recent Transactions:";
    static String invalidCreds = "Invalid Credentials. Try Again!";
    static String notAnOption = "That's not an option. Try Again!";
    static String details = "Customer Details";
    static String account = "Account";
    static String customer = "Customer";

    public void exit() {
        System.out.println("Goodbye!");
        System.exit(0);
    }

    public void userInput() {
        System.out.println(color.CYAN);
    }

    public void userChoice() {
        System.out.print(color.RESET);
    }

    public void choice() {
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println(color.GREEN);
        System.out.print("Enter Choice (1,2, or 3) :\n" + color.WHITE + "");
        userChoice();
    }

    public void transactions() {
        printMessage(recentTransactions);
    }

    public void displayInfo() {
        printMessage(details);
        printMessage(account);
        System.out.println("Id: " + c.getUserId());
        System.out.println("Balance: " + c.getBalance());
        printMessage(customer);
        System.out.println("NAME: " + c.getCustomer());
        System.out.println("ADDRESS: " + c.getAddress());
        System.out.println("CONTACT: " + c.getContact() + color.RESET);
        System.out.println(color.GREEN);
        System.out.print("Enter Choice (1,2,3,4,5 or 6) : \n");
        System.out.println(color.RESET);
    }

    public void loggedIn() {
        printMessage(welcomeCustomer);
        System.out.println("1. Deposit Amount");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Funds Transfer");
        System.out.println("4. View 5 Recent Transactions");
        System.out.println("5. Display Customer Information");
        System.out.println("6. Sign out\n");
        System.out.println(color.GREEN);
        System.out.print("Enter Choice (1,2,3,4,5 or 6) :\n");
        System.out.println(color.RESET);
    }

    public void credentials() {
        printMessage(enterLogin);
//        System.out.println("User Id :");
//        System.out.println("Password :");
    }

    public void invalidCreds() {
        // when error, make it red
        System.out.println(color.RED + invalidCreds);
    }

    public void notAnOption() {
        System.out.println(color.RED + notAnOption);
    }

    public void registration() {
        System.out.println();
        printMessage(enterDetails);
//        System.out.println("Customer Name:");
//        System.out.println("Customer address:");
//        System.out.println("Customer Contact Number:");
//        System.out.println("User Id :");
//        System.out.println("Password : 8 Characters With Lower,Upper & Special");
//        System.out.println("Initial Deposit Amount");
    }

    public void menu() {
        printMessage(welcome);
        choice();
    }

    private void printMessage(String msg) {
        System.out.print(color.BLUE + "+");
        int msgFormat = msg.length() + 2;
        for(int i = 0; i < msgFormat; i++) {
            System.out.print("-");
        }
        System.out.print("+\n| " + msg + " |\n+");
        for(int i = 0; i < msgFormat; i++) {
            System.out.print("-");
        }
        System.out.println("+");
        System.out.print(color.RESET);
    }
}

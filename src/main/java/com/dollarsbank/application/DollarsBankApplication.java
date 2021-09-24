package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;

public class DollarsBankApplication {

	public static void main(String[] args) {

		DollarsBankController dbc = new DollarsBankController();
		boolean run = true;
		while(run) {
			run = dbc.run();
		}
	}
}

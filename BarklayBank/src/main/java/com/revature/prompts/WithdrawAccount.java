package com.revature.prompts;

import java.util.Scanner;

import com.revature.daos.AccountDao;
import com.revature.model.Account;

/**
 * Prompt to withdraw amounts from a given account
 * 
 * @author carri
 *
 */
public class WithdrawAccount implements Prompt {

	private Scanner scan = new Scanner(System.in);
	private AccountDao accountDao = AccountDao.currentImplementation;

	/**
	 * Method to process withdrawal requests
	 * 
	 */
	@Override
	public Prompt run() {
		String input;

		while (true) {

			System.out.println(
					"Please enter the account number for the account you would like to withdraw cuteness points from. \n");
			input = scan.nextLine();

			int selectedAccountNumber = Integer.parseInt(input);
			selectedAccountNumber = selectedAccountNumber - 1;

			Account selectedAccount = accountDao.findAccount(selectedAccountNumber);

			System.out.println("How much would you like to withdraw? \n");
			System.out.println("Enter 1 if you had an accident in the house. (100 points)");
			System.out.println("Enter 2 if you chased the cat. (200 points)");
			System.out.println("Enter 3 if you jumped and knocked Grandma down. (300 points)");
			System.out.println("Enter 4 to use a custom ammount.");
			input = scan.nextLine();

			switch (input) {
			case "1":
				accountDao.withdraw(selectedAccount, 100);
				
				break;
				
			case "2":
				accountDao.withdraw(selectedAccount, 200);
				
				break;
				
			case "3":
				
				accountDao.withdraw(selectedAccount, 300);
				
				break;
				
			case "4":
				System.out.println("How much would you like to withdraw?");
				double newAmount = Double.valueOf(scan.nextLine());

				if (newAmount > selectedAccount.getBalance()) {
					System.out.println(
							"Sorry. You do not have enough cuteness points in the account to cover this amound.");
					System.out.println("Please try again once you have earned more points.");
				}

				if (newAmount > 0) {
					
					accountDao.withdraw(selectedAccount, newAmount);
				} else {
					System.out.println(
							"Negative amounts are not allowed here. Would you like to make a deposit instead?");
					return new HomePrompt();
				}

				break;

			default:
				System.out.println("We did not understand that selection, please try again");
				return new WithdrawAccount();
			}
			
			System.out.println("The current balance for this account is now " + selectedAccount.getBalance());
			return new HomePrompt();
			
		} 
	}

}

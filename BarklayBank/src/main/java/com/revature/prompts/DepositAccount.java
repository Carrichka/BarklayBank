package com.revature.prompts;

import java.util.Scanner;

import com.revature.daos.AccountDao;
import com.revature.model.Account;

/**
 * Prompt to handle deposit requests for a given account.
 * 
 * @author carri
 *
 */
public class DepositAccount implements Prompt {

	private Scanner scan = new Scanner(System.in);
	private AccountDao accountDao = AccountDao.currentImplementation;

	/**
	 * Method to handle deposit requests
	 * 
	 */
	@Override
	public Prompt run() {
		String input;

		while (true) {

			System.out.println(
					"Please enter the account number for the account you would like to deposit cuteness points into. \n");
			input = scan.nextLine();

			int selectedAccountNumber = Integer.parseInt(input);
			selectedAccountNumber = selectedAccountNumber - 1;

			Account selectedAccount = accountDao.findAccount(selectedAccountNumber);

			System.out.println("How much would you like to deposit? \n");
			System.out.println("Enter 1 if you played fetch. (100 points)");
			System.out.println("Enter 2 if you let the cat cuddle with you while you slept. (200 points)");
			System.out.println("Enter 3 if you played with the cat. (300 points)");
			System.out.println("Enter 4 to use a custom ammount.");
			input = scan.nextLine();

			switch (input) {
			case "1":
				accountDao.deposit(selectedAccount, 100);
				break;
			case "2":
				accountDao.deposit(selectedAccount, 200);
				break;
			case "3":
				accountDao.deposit(selectedAccount, 300);
				break;
			case "4":
				System.out.println("How much would you like to deposit?");
				double newAmount = Double.valueOf(scan.nextLine());

				if (newAmount > 0) {

					accountDao.deposit(selectedAccount, newAmount);
				} else {
					System.out.println(
							"Negative amounts are not allowed here. Would you like to make a withdrawl instead?");
					return new HomePrompt();
				}

				break;

			default:
				System.out.println("We did not understand that selection, please try again");
				return new DepositAccount();
			}

			System.out.println("The current balance for this account is now " + selectedAccount.getBalance());
			return new HomePrompt();
		}

	}

}

package com.revature.prompts;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.AccountDao;
import com.revature.model.Account;

/**
 * Prompt facilitates opening a new account.
 * 
 * @author carri
 *
 */
public class OpenAccounts implements Prompt {
	
	private Scanner scan = new Scanner(System.in);
	private AccountDao accountDao = AccountDao.currentImplementation;

	/**
	 * Method to open new accounts
	 * 
	 */
	@Override
	public Prompt run() {
		
		System.out.println("Enter a name for your new account");
		String name = scan.nextLine();
		
		List<Account> savedAccount = accountDao.findAll();
		int newAccount = savedAccount.size()+ 1;
		
		double value;

		while (true) {

			try {

				System.out.println("Enter the new account's beginning cuteness points balance: ");

				value = Double.valueOf(scan.nextLine());

				break; // exit while loop

			} catch (NumberFormatException e) {

				System.out.println("that is not a valid number, try again");

			}//end try catch

		}//end while
		
		Account b = new Account(newAccount, name, value);
		
		accountDao.save(b);
		
		System.out.println("Your account has been created. \n");
		
		return new HomePrompt();
	}//end Prompt

}//end OpenAccount class

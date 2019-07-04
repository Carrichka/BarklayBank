package com.revature.prompts;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.AccountDao;
import com.revature.model.Account;

/**
 * Prompt facilitates the removal of an existing account
 * 
 * @author carri
 *
 */
public class RemoveAccount implements Prompt {
	
	private Scanner scan = new Scanner(System.in);
	private AccountDao accountDao = AccountDao.currentImplementation;

	/**
	 * Method to remove accounts
	 * 
	 */
	@Override
	public Prompt run() {
		String input;
		
		while (true) {
			
			System.out.println("Here are all of your current open accounts. \n");
		
			List<Account> account = accountDao.findAll();
			for (Account c : account) { 
				System.out.println(c);
			}// end enhanced for loop to iterate through the account set
			
			System.out.println("Please enter the account number for the account you would like to remove.");
			System.out.println("");
			input = scan.nextLine();
			
			System.out.println("we will remove account number " + input);
			int deletedAccount = Integer.parseInt(input);
			deletedAccount = deletedAccount - 1;
			accountDao.remove(deletedAccount);
			
			return new HomePrompt();
		}

		
		
		
	}

}

package com.revature.prompts;

import java.util.List;
import com.revature.daos.AccountDao;
import com.revature.model.Account;

/**
 * Prompt displays a list of all existing accounts.
 * 
 */
public class ViewAccounts implements Prompt {

	private AccountDao accountDao = AccountDao.currentImplementation;

	/**
	 * Method to display open accounts
	 * 
	 */
	@Override
	public Prompt run() {
			
		while (true) {
			System.out.println("Here are all of your current open accounts. \n");
			
			List<Account> account = accountDao.findAll();
			for (Account c : account) { 
				System.out.println(c);
			}// end enhanced for loop to iterate through the account set
				
				return new HomePrompt();
			
		}//end of while
		
	}//end do while

}//end ViewAccountsPrompt class

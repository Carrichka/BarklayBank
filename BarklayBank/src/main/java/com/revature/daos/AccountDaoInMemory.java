package com.revature.daos;

import java.util.LinkedList;
import java.util.List;

import com.revature.model.Account;

/**
 * Holds sample account information and methods to manipulate that data in the
 * application
 * 
 * @author carri
 *
 */
public class AccountDaoInMemory implements AccountDao {

	/**
	 * Sample account information
	 */
	private List<Account> account;

	public AccountDaoInMemory() {

		account = new LinkedList<>();
		account.add(new Account(1, "Barbara", 100.00));
		account.add(new Account(2, "Linn", 200.00));
		account.add(new Account(3, "Sherry", 300.00));
		account.add(new Account(4, "Kevin", 400.00));
	}

	/**
	 * Method to save a new account to the in memory LinkedList
	 * 
	 * @param Account object to add to the in memory LinkedList
	 */
	@Override
	public void save(Account b) {
		account.add(b);

	}

	/**
	 * Method to remove a new account to the in memory LinkedList
	 * 
	 * @param b index to locate an account to be removed
	 */
	@Override
	public void remove(int b) {
		account.remove(b);

	}

	/**
	 * Method to deposit into a given account from the in memory LinkedList
	 * 
	 * @param Account object for the selected account to deposit into
	 * @param deposit amount
	 */
	@Override
	public void deposit(Account b, double deposit) {

		double newBalance = b.getBalance() + deposit;
		b.setBalance(newBalance);
		account.set(b.getAccountNumber() - 1, b);

	}

	/**
	 * Method to withdraw into a given account from the in memory LinkedList
	 * 
	 * @param Account  object for the selected account to withdraw from
	 * @param withdraw amount
	 */
	@Override
	public void withdraw(Account b, double withdraw) {

		double newBalance = b.getBalance() - withdraw;
		b.setBalance(newBalance);
		account.set(b.getAccountNumber() - 1, b);

	}

	/**
	 * Method to find all accounts in the in memory LinkedList
	 * 
	 */
	@Override
	public List<Account> findAll() {
		return account;
	}

	/**
	 * Method to find a specific account in the in memory LinkedList
	 * 
	 * @param b index to locate a desired account
	 */
	@Override
	public Account findAccount(int b) {
		Account selectedAccount = new Account();
		selectedAccount = account.get(b);
		return selectedAccount;
	}

}

package com.revature.model;

/**
 * Account model
 * 
 * @author carri
 *
 */
public class Account {

	private String name;
	private double balance;
	private int accountNumber;

	/**
	 * Constructor
	 */
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param accountNumber
	 * @param name
	 * @param balance
	 */
	public Account(int accountNumber, String name, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}

	/**
	 * Name getter
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Name setter
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Balance getter
	 * 
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Balance setter
	 * 
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Account number getter
	 * 
	 * @return account number
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Account number setter
	 * 
	 * @param accountNumber
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Account object override hashCode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Account object override equals
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	/**
	 * Account object override toString
	 */
	@Override
	public String toString() {
		return "Account [name=" + name + ", balance=" + balance + ", accountNumber=" + accountNumber + "]";
	}

}// end Account class

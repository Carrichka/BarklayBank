package com.revature.daos;

import java.util.List;
import com.revature.model.Account;

/**
 * 
 * @author carri
 *
 */
public interface AccountDao {

	AccountDao currentImplementation = new AccountDaoInMemory();

	void save(Account b);

	void remove(int b);

	void deposit(Account b, double deposit);
	
	void withdraw(Account b, double withdraw);

	List<Account> findAll();

	Account findAccount(int b);
}

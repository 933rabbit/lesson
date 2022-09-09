package com.twipper.service;

import java.util.List;

import com.twipper.bean.Account;

public interface AccountService {

	/**
	 * Register a new customer information.
	 *
	 * @param account customer object which we want to register
	 * @return account object registered
	 */
	Account register(Account account);

	/**
	 * Retrieve all account information.
	 *
	 * @return all account information
	 */
	List<Account> retrieve();

	/**
	 * Retrieve the account information having the same id as provided.
	 *
	 * @param id identity of account information
	 * @return account information having the same id as provided
	 */
	Account retrieve(String id);

	/**
	 * Update account information.
	 *
	 * @param account customer object which we want to update
	 * @return account object updated
	 */
	Account update(Account account);

	/**
	 * Delete customer information.
	 *
	 * @param id identity of account information
	 * @return identity of deleted account
	 */
	String delete(String id);
}
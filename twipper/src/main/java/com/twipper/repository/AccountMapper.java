package com.twipper.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.twipper.bean.Account;

@Mapper
public interface AccountMapper {

	/**
	 * Insert a new account record to the database.
	 *
	 * @param account account object which we want to insert
	 * @return the number of inserted records
	 */
	int insert(Account account);

	/**
	 * Select all records from database.
	 *
	 * @return all records stored in database
	 */
	List<Account> selectAll();

	/**
	 * Retrieve a record with the same id as provided.
	 *
	 * @param id identity of account record
	 * @return account record which has the same id as provided
	 */
	Account select(String id);

	/**
	 * Update an existing record.
	 *
	 * @param account account object having the updating contents
	 * @return the number of updated records
	 */
	int update(Account account);

	/**
	 * Delete a record with the same id as provided.
	 *
	 * @param id identity of account record
	 * @return the number of deleted records
	 */
	int delete(String id);
}
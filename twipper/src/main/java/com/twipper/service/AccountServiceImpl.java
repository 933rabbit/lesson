package com.twipper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twipper.bean.Account;
import com.twipper.repository.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper mapper;

	@Override
	public Account register(Account account) {
		/*		String formattedEmail = formatEmail(account.getEmail());
				account.setEmail(formattedEmail);
		
				mapper.insert(account);
		*/ return account;
	}

	@Override
	public List<Account> retrieve() {
		return mapper.selectAll();
	}

	@Override
	public Account retrieve(String id) {
		return mapper.select(id);
	}

	@Override
	public Account update(Account account) {
		/*		String formattedEmail = formatEmail(account.getEmail());
				account.setEmail(formattedEmail);
		
				mapper.update(account);
				*/return account;
	}

	@Override
	public String delete(String id) {
		mapper.delete(id);
		return id;
	}

	private String formatEmail(String email) {
		String[] separatedEmail = email.split("@");
		return separatedEmail[0] + "@" + separatedEmail[1].toLowerCase();
	}

}
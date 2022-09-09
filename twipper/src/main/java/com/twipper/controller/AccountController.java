package com.twipper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twipper.bean.Account;
import com.twipper.service.AccountService;

@RestController
//@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping
	public Account post(@Validated @RequestBody Account account, Errors errors) {
		// If the fields of requested account object are invalid,
		// throw Runtime Exception with validation errors.
		// NOTE: You can set HTTP status code and return it instead of throwing error.
		if (errors.hasErrors()) {
			throw new RuntimeException((Throwable) errors);
		}
		// NOTE: You can also validate whether insertion succeeded or not here.
		return accountService.register(account);
	}

	@GetMapping
	public List<Account> get() {
		return accountService.retrieve();
	}

	@GetMapping("/{id}")
	public Account get(@PathVariable String id) {
		return accountService.retrieve(id);
	}

	@PatchMapping
	public Account patch(@Validated @RequestBody Account account, Errors errors) {
		if (errors.hasErrors()) {
			throw new RuntimeException((Throwable) errors);
		}
		return accountService.update(account);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		return accountService.delete(id);
	}
}
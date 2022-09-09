package com.twipper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twipper.bean.Account;
import com.twipper.bean.Customer;
import com.twipper.repository.AccountMapper;
import com.twipper.service.CustomerService;

@RestController
//@RequestMapping
@RequestMapping("/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public Customer post(@Validated @RequestBody Customer customer, Errors errors) {
		// If the fields of requested customer object are invalid,
		// throw Runtime Exception with validation errors.
		// NOTE: You can set HTTP status code and return it instead of throwing error.
		if (errors.hasErrors()) {
			throw new RuntimeException((Throwable) errors);
		}
		// NOTE: You can also validate whether insertion succeeded or not here.
		return customerService.register(customer);
	}

	@GetMapping("/customers")
	public List<Customer> get() {
		return customerService.retrieve();
	}

	@GetMapping("/customers/{id}")
	public Customer get(@PathVariable String id) {
		return customerService.retrieve(id);
	}

	@PatchMapping
	public Customer patch(@Validated @RequestBody Customer customer, Errors errors) {
		if (errors.hasErrors()) {
			throw new RuntimeException((Throwable) errors);
		}
		return customerService.update(customer);
	}

	/*	  @DeleteMapping("/{id}")
		  public String delete(@PathVariable String id) {
		    return customerService.delete(id);
		  }
		 */

	@Autowired
	private AccountMapper mapper;

	//		@Override
	public Account register(Account account) {
		/*		String formattedEmail = formatEmail(account.getEmail());
				account.setEmail(formattedEmail);
		
				mapper.insert(account);
		*/ return account;
	}

	//		@Override
	@GetMapping("/accounts")
	public List<Account> retrieve() {
		return mapper.selectAll();
	}

	//		@Override
	public Account retrieve(String id) {
		return mapper.select(id);
	}

	//		@Override
	public Account update(Account account) {
		/*		String formattedEmail = formatEmail(account.getEmail());
				account.setEmail(formattedEmail);
		
				mapper.update(account);
				*/return account;
	}

	//		@Override
	public String delete(String id) {
		mapper.delete(id);
		return id;
	}

	private String formatEmail(String email) {
		String[] separatedEmail = email.split("@");
		return separatedEmail[0] + "@" + separatedEmail[1].toLowerCase();
	}
}
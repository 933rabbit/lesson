package com.twipper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twipper.bean.Customer;
import com.twipper.repository.CustomerMapper;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	 private CustomerMapper mapper;

	

	  @Override
	  public Customer register(Customer customer) {
	    String formattedEmail = formatEmail(customer.getEmail());
	    customer.setEmail(formattedEmail);

	    mapper.insert(customer);
	    return customer;
	  }

	  @Override
	  public List<Customer> retrieve() {
	    return mapper.selectAll();
	  }

	  @Override
	  public Customer retrieve(String id) {
	    return mapper.select(id);
	  }

	  @Override
	  public Customer update(Customer customer) {
	    String formattedEmail = formatEmail(customer.getEmail());
	    customer.setEmail(formattedEmail);

	    mapper.update(customer);
	    return customer;
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

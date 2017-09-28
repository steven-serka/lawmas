package com.ims.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ims.beans.Card;
import com.ims.beans.Customer;
import com.ims.beans.State;
import com.ims.daos.CustomerDao;
import com.ims.dtos.CustomerDto;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public Customer createOrUpdate(Customer c) {
		return customerDao.createOrUpdateCustomer(c);
	}
	
	public CustomerDto authenticateUser(CustomerDto customerDto) {
		Customer customer = customerDao.getCustomerByUsernameAndPassword(customerDto.getEmail(),customerDto.getPassword());
		if(customer != null) {
			customerDto.setAuthenticated(true);
			customerDto.setId(customer.getId());
		}
		return customerDto;
	}
	
	public List<Customer> getAll() {
		return customerDao.getAll();
	}

	public Customer getById(int i) {
		return customerDao.getCustomerById(i);
	}
	
	public void remove(Customer c) {
		customerDao.removeCustomer(c);
	}
	
	public List<Customer> getAllByLastName(String ln){
		return customerDao.getAllByLastName(ln);
	}
	
	
	public List<Customer> getAllByState(State s){
		return customerDao.getAllByState(s);
	}
	
	public Customer getByCard(Card c) {
		return customerDao.getByCard(c);
	}
	
	public Customer getByCardId(int id) {
		return customerDao.getByCardId(id);
	}
}

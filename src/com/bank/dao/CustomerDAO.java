package com.bank.dao;

import java.util.List;

import com.bank.dto.Customer;

public interface CustomerDAO {

	public boolean insertCustomer(Customer c);
	public Customer getCustomer(long accno, int pin);
	public Customer getCustomer(long phone, String mail );
	public Customer getCustomer(long accno);
	public List<Customer> getCustomer();
	public boolean deleteCustomer(Customer c);
	public boolean updateCustomer(Customer c);
	
}

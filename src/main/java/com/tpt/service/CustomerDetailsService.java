package com.tpt.service;

import java.util.List;

import com.tpt.model.CustomerDetails;

public interface CustomerDetailsService {

	String insertCustomerDetails(CustomerDetails customerDetails);

	List<CustomerDetails> getCustomers();

	Integer getCustomersCount();

}

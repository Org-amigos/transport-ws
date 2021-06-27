package com.tpt.service;

import java.util.List;

import com.tpt.constants.Response;
import com.tpt.model.CustomerDetails;

public interface CustomerDetailsService {

	Response insertCustomerDetails(CustomerDetails customerDetails);

	List<CustomerDetails> getCustomers();

	Integer getCustomersCount();

	CustomerDetails getParticularCustomerDetails(Integer customerId);

	Response deleteParticularCustomer(Integer customerId);

}

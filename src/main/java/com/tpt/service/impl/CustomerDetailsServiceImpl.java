package com.tpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpt.constants.CommonConstansts;
import com.tpt.model.CustomerDetails;
import com.tpt.repository.CustomerDetailsDao;
import com.tpt.service.CustomerDetailsService;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	CustomerDetailsDao customerDetailsDao;

	public String insertCustomerDetails(CustomerDetails customerDetails) {
		if (customerDetailsDao.save(customerDetails) != null) {
			return CommonConstansts.ResponseStatus.SUCCESS;
		}
		return CommonConstansts.ResponseStatus.FAIL;
	}

	@Override
	public List<CustomerDetails> getCustomers() {
		return (List<CustomerDetails>) customerDetailsDao.findAll();
	}

	@Override
	public Integer getCustomersCount() {
		return (int) customerDetailsDao.count();
	}

	@Override
	public CustomerDetails getParticularCustomerDetails(Integer customerId) {

		return customerDetailsDao.findByCustomerId(customerId);
	}

	@Override
	public void deleteParticularCustomer(Integer customerId) {

		customerDetailsDao.deleteById(customerId);
	}

}

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
		
		//Exception Handling Required
		CustomerDetails customerMailObj = customerDetailsDao.findByCustomerEmail(customerDetails.getCustomerEmail());
		CustomerDetails customerPhoneObj = customerDetailsDao.findByPrimaryPhoneNumber(customerDetails.getPrimaryPhoneNumber());
		
		if ((customerMailObj == null) && (customerPhoneObj == null)) {
			if (customerDetailsDao.save(customerDetails) != null) {
				return CommonConstansts.ResponseStatus.SUCCESS;
			}
			return CommonConstansts.ResponseStatus.FAIL;
		}		
		else if(customerMailObj!=null){
			return CommonConstansts.CustomerDetails.EMAIL_EXIST;
		}
		else {
			return CommonConstansts.CustomerDetails.PHONE_EXIST;
		}
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
		//Exception Handling Required
		customerDetailsDao.deleteById(customerId);
	}

}

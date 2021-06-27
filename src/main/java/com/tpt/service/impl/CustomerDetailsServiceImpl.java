package com.tpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tpt.constants.CommonConstansts;
import com.tpt.constants.Response;
import com.tpt.model.CustomerDetails;
import com.tpt.repository.CustomerDetailsDao;
import com.tpt.service.CustomerDetailsService;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	CustomerDetailsDao customerDetailsDao;

	public Response insertCustomerDetails(CustomerDetails customerDetails) {
		
		Response response = new Response();
		Response.Status status = new Response.Status();
		CustomerDetails customerMailObj = customerDetailsDao.findByCustomerEmail(customerDetails.getCustomerEmail());
		CustomerDetails customerPhoneObj = customerDetailsDao
				.findByPrimaryPhoneNumber(customerDetails.getPrimaryPhoneNumber());

		if ((customerMailObj == null) && (customerPhoneObj == null)) {
			if (customerDetailsDao.save(customerDetails) != null) {
				response.setData(customerDetails);
				status.setMessage(CommonConstansts.CustomerDetails.CUSTOMER_SAVED);
				status.setSuccess(CommonConstansts.ResponseStatus.SUCCESS);	
			}
		} else if (customerMailObj != null) {
			status.setMessage(CommonConstansts.CustomerDetails.EMAIL_EXIST);
			status.setSuccess(CommonConstansts.ResponseStatus.FAIL);
		} else {
			status.setMessage(CommonConstansts.CustomerDetails.PHONE_EXIST);
			status.setSuccess(CommonConstansts.ResponseStatus.FAIL);
		}
		response.setStatus(status);
		return response;
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
	public Response deleteParticularCustomer(Integer customerId) {
		Response response = new Response();
		Response.Status status = new Response.Status();
		try {
			customerDetailsDao.deleteById(customerId);
			status.setMessage(CommonConstansts.CustomerDetails.CUSTOMER_DELETED);
			status.setSuccess(CommonConstansts.ResponseStatus.SUCCESS);
		} catch (EmptyResultDataAccessException e) {
			status.setMessage(CommonConstansts.ResponseStatus.FAIL);
			status.setSuccess(CommonConstansts.CustomerDetails.CUSTOMER_NOTDELETED);
		} catch (Exception e) {
			status.setMessage(CommonConstansts.ResponseStatus.FAIL);
			status.setSuccess(CommonConstansts.ResponseStatus.SERVERUNDERMAINTANENCE);
		}
		response.setStatus(status);
		return response;
	}

}

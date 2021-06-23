package com.tpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpt.model.CustomerDetails;
@Repository
public interface CustomerDetailsDao extends  JpaRepository<CustomerDetails, Integer>{

	CustomerDetails findByCustomerId(Integer customerId);

	CustomerDetails findByPrimaryPhoneNumber(String primaryPhoneNumber);

	CustomerDetails findByCustomerEmail(String customerEmail);
	
	

}

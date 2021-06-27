package com.tpt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tpt.constants.Response;
import com.tpt.model.CustomerDetails;
import com.tpt.service.CustomerDetailsService;

@RestController
@RequestMapping(value = { "/customer" })
public class CustomerDetailsController {

	@Autowired
	CustomerDetailsService customerDetailsService;

	@PostMapping(value = "/insert")
	public Response insertCustomerDetails(@RequestBody CustomerDetails customerDetails) {

		return customerDetailsService.insertCustomerDetails(customerDetails);
	}

	@GetMapping(value = "/getCustomers")
	public List<CustomerDetails> getCustomers() {

		return customerDetailsService.getCustomers();
	}

	@GetMapping(value = "/getCustomersCount")
	public Integer getCustomersCount() {

		return customerDetailsService.getCustomersCount();
	}

	@GetMapping(value = "/getParticular")
	public CustomerDetails getParticularCustomerDetails(@RequestParam(value = "customerId") Integer customerId) {

		return customerDetailsService.getParticularCustomerDetails(customerId);
	}
	
	@DeleteMapping(value = "/delete")
	public Response deleteParticularCustomer(@RequestParam(value = "customerId") Integer customerId) {
		return customerDetailsService.deleteParticularCustomer(customerId);
	}

}

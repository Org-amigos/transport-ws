package com.tpt.constants;

public interface CommonConstansts {
	
	
	public interface ResponseStatus {
		String SUCCESS = "Success";
		String FAIL = "Fail";
		String SERVERUNDERMAINTANENCE = "Sorry!! Server is under maintenance";
	}

	public interface CustomerDetails {
		String EMAIL_EXIST = "Customer Email already exists!!";
		String PHONE_EXIST = "Customer Phone Number already exist";
		String CUSTOMER_DELETED = "Customer Details Deleted Successfully";
		String CUSTOMER_NOTDELETED = "Oops!! Customer Details Not Deleted";
		String CUSTOMER_SAVED = "Customer Details Saved Successfully!!";
		

	}
	
	public interface ClientDetails {
		String EMAIL_EXIST = "Client Email already exists!!";
		String PHONE_EXIST = "Client Phone Number already exist";
		String CLIENT_DELETED = "Client Details Deleted Successfully";
		String CLIENT_NOTDELETED = "Oops!! Client Details Not Deleted";
		String CLIENT_SAVED = "Client Detais Saved Successfully!!";
		

	}
}

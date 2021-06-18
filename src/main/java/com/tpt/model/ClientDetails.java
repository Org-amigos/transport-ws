package com.tpt.model;

public class ClientDetails {

	public Integer clientId;
	public String clientName;
	public String clientEmail;
	public String primaryPhoneNumber;
	public String alternatePhoneNumber;
	public String officeAddress;
	
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getPrimaryPhoneNumber() {
		return primaryPhoneNumber;
	}
	public void setPrimaryPhoneNumber(String primaryPhoneNumber) {
		this.primaryPhoneNumber = primaryPhoneNumber;
	}
	public String getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}
	public void setAlternatePhoneNumber(String alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
}

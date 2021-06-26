package com.tpt.service;

import java.util.List;

import com.tpt.model.ClientDetails;

public interface ClientDetailsService {
	
	String insertClientDetails(ClientDetails clientDetails);

	List<ClientDetails> getClients();

	Integer getClientsCount();

	ClientDetails getParticularClientDetails(Integer clientId);

	void deleteParticularClient(Integer clientId);


}

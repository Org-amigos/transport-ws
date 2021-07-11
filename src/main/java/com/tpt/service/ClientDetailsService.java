package com.tpt.service;

import java.util.List;

import com.tpt.constants.Response;
import com.tpt.model.ClientDetails;

public interface ClientDetailsService {
	
	Response insertClientDetails(ClientDetails clientDetails);

	List<ClientDetails> getClients();

	Integer getClientsCount();

	ClientDetails getParticularClientDetails(Integer clientId);

	Response deleteParticularClient(Integer clientId);

	Response softDeleteParticularClient(Integer clientId, Boolean isActive);
	


}

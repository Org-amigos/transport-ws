package com.tpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpt.constants.CommonConstansts;
import com.tpt.model.ClientDetails;
import com.tpt.repository.ClientDetailsDao;
import com.tpt.service.ClientDetailsService;

@Service
public class ClientDetailsServiceimpl implements ClientDetailsService {
	
	@Autowired
	ClientDetailsDao clientDetailsDao;


	public String insertClientDetails(ClientDetails clientDetails) {
		if (clientDetailsDao.save(clientDetails) != null) {
			return CommonConstansts.ResponseStatus.SUCCESS;
		}
		return CommonConstansts.ResponseStatus.FAIL;
		
	}

	@Override
	public List<ClientDetails> getClients() {
		
		return  (List<ClientDetails>) clientDetailsDao.findAll();
	}

	@Override
	public Integer getClientsCount() {
		
		return (int) clientDetailsDao.count();
	}

	@Override
	public ClientDetails getParticularClientDetails(Integer clientId) {
	
		return clientDetailsDao.findByClientId(clientId);
	}

	@Override
	public void deleteParticularClient(Integer clientId) {
		
		clientDetailsDao.deleteById(clientId);
	}

}

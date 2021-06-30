package com.tpt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.tpt.constants.CommonConstansts;
import com.tpt.constants.Response;
import com.tpt.model.ClientDetails;
import com.tpt.model.CustomerDetails;
import com.tpt.repository.ClientDetailsDao;
import com.tpt.service.ClientDetailsService;

@Service
public class ClientDetailsServiceimpl implements ClientDetailsService {
	
	@Autowired
	ClientDetailsDao clientDetailsDao;


	public Response insertClientDetails(ClientDetails clientDetails) {
		Response response = new Response();
		Response.Status status = new Response.Status();
		ClientDetails clientMailObj = clientDetailsDao.findByClientEmail(clientDetails.getClientEmail());
		ClientDetails clientPhoneObj = clientDetailsDao
				.findByPrimaryPhoneNumber(clientDetails.getPrimaryPhoneNumber());

		if ((clientMailObj == null) && (clientPhoneObj == null)) {
			if (clientDetailsDao.save(clientDetails) != null) {
				response.setData(clientDetails);
				status.setMessage(CommonConstansts.ClientDetails.CLIENT_SAVED);
				status.setSuccess(CommonConstansts.ResponseStatus.SUCCESS);	
			}
		} else if (clientMailObj != null) {
			status.setMessage(CommonConstansts.ClientDetails.EMAIL_EXIST);
			status.setSuccess(CommonConstansts.ResponseStatus.FAIL);
		} else {
			status.setMessage(CommonConstansts.ClientDetails.PHONE_EXIST);
			status.setSuccess(CommonConstansts.ResponseStatus.FAIL);
		}
		response.setStatus(status);
		return response;
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
	public Response deleteParticularClient(Integer clientId) {
		Response response = new Response();
		Response.Status status = new Response.Status();
		try {
		clientDetailsDao.deleteById(clientId);
		status.setMessage(CommonConstansts.ClientDetails.CLIENT_DELETED);
		status.setSuccess(CommonConstansts.ResponseStatus.SUCCESS);
		    }
		catch (EmptyResultDataAccessException e) {
			status.setMessage(CommonConstansts.ResponseStatus.FAIL);
			status.setSuccess(CommonConstansts.ClientDetails.CLIENT_NOTDELETED);
		}
		catch (Exception e) {
				status.setMessage(CommonConstansts.ResponseStatus.FAIL);
				status.setSuccess(CommonConstansts.ResponseStatus.SERVERUNDERMAINTANENCE);
		}
		response.setStatus(status);
		return response;
	}

}











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
import com.tpt.model.ClientDetails;
import com.tpt.service.ClientDetailsService;

@RestController
@RequestMapping(value = { "/client" })
public class ClientDetailsController {
	
	@Autowired
	ClientDetailsService clientdetailsservice;
	
	@PostMapping(value = "/insert")
	public Response insertClientDetails(@RequestBody ClientDetails clientDetails) {

		return clientdetailsservice.insertClientDetails(clientDetails);
	}

	@GetMapping(value = "/getClients")
	public List<ClientDetails> getClients() {

		return clientdetailsservice.getClients();
	}

	@GetMapping(value = "/getClientsCount")
	public Integer getClientsCount() {

		return clientdetailsservice.getClientsCount();
	}

	@GetMapping(value = "/getParticular")
	public ClientDetails getParticularClientDetails(@RequestParam(value = "clientId") Integer clientId) {

		return clientdetailsservice.getParticularClientDetails(clientId);
	}
	
	@DeleteMapping(value = "/delete")
	public Response deleteParticularClient(@RequestParam(value = "clientId") Integer clientId) {
		return clientdetailsservice.deleteParticularClient(clientId);
	}
	
	
	@DeleteMapping(value = "/softDelete")
	public Response softDeleteParticularClient(@RequestParam(value = "isActive") Boolean isActive,
			@RequestParam(value = "clientId") Integer clientId) {
		return clientdetailsservice.softDeleteParticularClient(clientId, isActive);
	}
	
	
	

}

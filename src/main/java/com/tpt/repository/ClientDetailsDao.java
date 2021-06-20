package com.tpt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tpt.model.ClientDetails;


public interface ClientDetailsDao extends JpaRepository<ClientDetails , Integer>{

	ClientDetails findByClientId(Integer clientId);
}

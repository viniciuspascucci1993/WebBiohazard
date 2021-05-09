package com.vinicius.web.biohazard.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.web.biohazard.domain.Agent;
import com.vinicius.web.biohazard.repositories.AgentRepository;
import com.vinicius.web.biohazard.service.exception.ObjectNotFoundException;

/**
 * Classe de service responsável por conter operações de CRUD só que pela camada de serviço que será alimentada pela camada de resource.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@Service
public class AgenteService {

	private AgentRepository agentRepository;

	@Autowired
	public AgenteService(AgentRepository agentRepository) {
		this.agentRepository = agentRepository;
	}
	
	public Agent findById( Integer id ) {
		
		Optional<Agent> agent = agentRepository.findById(id);
		return agent.orElseThrow(() -> new ObjectNotFoundException("Identifier was not found! Id: " + id + ", Type: " + Agent.class.getName()));
	}
	
	public List<Agent> findAll() {
		return agentRepository.findAll();
	}
	
	public Agent create( Agent obj ) {
		
		obj.setId(null);
		return agentRepository.save(obj);
	}
	
}

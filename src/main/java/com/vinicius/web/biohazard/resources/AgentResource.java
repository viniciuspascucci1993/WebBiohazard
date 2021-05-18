package com.vinicius.web.biohazard.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vinicius.web.biohazard.domain.Agent;
import com.vinicius.web.biohazard.domain.dto.AgentDTO;
import com.vinicius.web.biohazard.service.AgenteService;

/**
 * Classe de resource responsável por realizar operações de CRUD.
 * @author Vinicius-PC - Vinicius Torres Pascucci.
 */
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/agents")
public class AgentResource {
	
	private AgenteService agenteService;

	@Autowired
	public AgentResource(AgenteService agenteService) {
		this.agenteService = agenteService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Agent> findById( @PathVariable Integer id ) {
		
		Agent agent = agenteService.findById(id);
		return ResponseEntity.ok().body(agent);
	}
	
	@GetMapping
	public ResponseEntity<List<AgentDTO>> findAll() {
		
		List<Agent> list = agenteService.findAll();
		
		List<AgentDTO> listDto = list.stream().map(agentObj -> new AgentDTO(agentObj)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<Agent> create ( @RequestBody Agent agentObj ) {
		
		agentObj = agenteService.create(agentObj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agentObj.getId()).toUri();
		
		return ResponseEntity.created(uri).body(agentObj);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AgentDTO> update( @PathVariable Integer id, @RequestBody AgentDTO objDto ) {
		
		Agent newObj = agenteService.update(id, objDto);
		
		return ResponseEntity.ok().body(new AgentDTO(newObj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delet( @PathVariable Integer id ) {
		
		agenteService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}

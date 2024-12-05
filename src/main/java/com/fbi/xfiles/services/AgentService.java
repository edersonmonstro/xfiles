package com.fbi.xfiles.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fbi.xfiles.domain.dto.AgentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbi.xfiles.domain.Agent;
import com.fbi.xfiles.domain.Department;
import com.fbi.xfiles.repositories.AgentRepository;

@Service
public class AgentService {

	@Autowired
	AgentRepository repository;
	
	public List<AgentDTO> findAll(){
		//return repository.findAllWithDepartment();
		return repository.findAll().stream()
				.map(this::toAgentDTO)
				.collect(Collectors.toList());
	}

	private AgentDTO toAgentDTO(Agent entity) {
		AgentDTO.Builder builder = new AgentDTO.Builder()
				.id(entity.getId())
				.name(entity.getName());

		// Adiciona apenas se estiver presente
		if (entity.getBirthDate() != null) {
			builder.birthDate(entity.getBirthDate());
		}
		if (entity.getDepartment() != null) {
			builder.department(entity.getDepartment());
		}

		return builder.build();
	}

	public List<Agent> findByName(String name){
		return repository.findAllByName(name);
	}

	public Agent getOne(UUID id){
		return repository.getOne(id);
	}

	public Agent save(Agent d) {
		return repository.save(d);
	}

	public void deleteById(UUID id){
		repository.deleteById(id);
	}

	public void deleteAll(){
		repository.deleteAll();
	}

	public List<Agent> findAgentsByDepartment(Department department) {
		return repository.findAgentsByDepartment(department);
	}
	
	
}
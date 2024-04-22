package com.fbi.xfiles.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbi.xfiles.domain.Agent;
import com.fbi.xfiles.domain.Department;
import com.fbi.xfiles.repositories.AgentRepository;

@Service
public class AgentService {

	@Autowired
	AgentRepository repository;
	
	public List<Agent> findAll(){
		return repository.findAll();
	}
	
	public Agent save(Agent d) {
		return repository.save(d);
	}
	
	public List<Agent> getAllAgents() {
        return repository.findAll();
    }

	public List<Agent> findAgentsByDepartment(Department department) {
		return repository.findAgentsByDepartment(department);
	}
	
}
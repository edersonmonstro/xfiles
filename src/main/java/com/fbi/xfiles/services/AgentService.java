package com.fbi.xfiles.services;

import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbi.xfiles.domain.Agent;
import com.fbi.xfiles.repositories.AgentRepository;

@Service
public class AgentService {

	@Autowired
	AgentRepository repository;
	
	public List<Agent> findAll(){
		return repository.findAllWithDepartment();
	}

	public List<Agent> findByName(String name){
		return repository.findAllByName(name);
	}

	public Agent getOne(Integer id){
		return repository.getOne(id);
	}

	public Agent save(Agent d) {
		return repository.save(d);
	}

	public void deleteById(Integer id){
		repository.deleteById(id);
	}

	public void deleteAll(){
		repository.deleteAll();

	public List<Agent> findAgentsByDepartment(Department department) {
		return repository.findAgentsByDepartment(department);

	}
	
}
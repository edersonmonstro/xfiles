package com.fbi.xfiles.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbi.xfiles.domain.Department;
import com.fbi.xfiles.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repository;

	public List<Department> findAll(){
		return repository.findAllWithAgents();
	}

	public List<Department> findByName(String name){
		return repository.findAllByName(name);
	}

	public Department getOne(UUID id){
		return repository.getOne(id);
	}

	public Department save(Department d) {
		return repository.save(d);
	}

	public void deleteById(UUID id){
		repository.deleteById(id);
	}

	public void deleteAll(){
		repository.deleteAll();
	}

	public List<Department> findByActive(Boolean active){
		return repository.findAllByActive(active);
	}

	public Optional<Department> findById(UUID id){
		return repository.findById(id);
	}

}
package com.fbi.xfiles.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbi.xfiles.domain.Department;
import com.fbi.xfiles.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	DepartmentRepository repository;

	public List<Department> findAll(){
		return repository.findAll();
	}

	public List<Department> findByName(String name){
		return repository.findAllByName(name);
	}

	public Department getOne(Integer id){
		return repository.getOne(id);
	}

	public Department save(Department d) {
		return repository.save(d);
	}

	public void deleteById(Integer id){
		repository.deleteById(id);
	}

	public void deleteAll(){
		repository.deleteAll();
	}

	public List<Department> findByActive(Boolean active){
		return repository.findAllByActive(active);
	}

}
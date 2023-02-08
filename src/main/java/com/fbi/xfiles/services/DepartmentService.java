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

	public List<Department> findAll() {
		return repository.findAll();
	}

	public void save(Department s) {
		repository.save(s);
	}

}
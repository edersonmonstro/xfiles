package com.fbi.xfiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbi.xfiles.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
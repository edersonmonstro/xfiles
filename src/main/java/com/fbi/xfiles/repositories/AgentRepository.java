package com.fbi.xfiles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fbi.xfiles.domain.Agent;
import com.fbi.xfiles.domain.Department;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
	
	@Query("SELECT a FROM Agent a WHERE a.department = :department ORDER BY a.id DESC")
	List<Agent> findAgentsByDepartment(@Param("department") Department department);

	List<Agent> findByDepartment(Department department);
}
package com.fbi.xfiles.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fbi.xfiles.domain.Agent;
import com.fbi.xfiles.domain.Department;

public interface AgentRepository extends JpaRepository<Agent, UUID> {

	@Query("SELECT a FROM Agent a WHERE a.department = :department ORDER BY a.id DESC")
	List<Agent> findAgentsByDepartment(@Param("department") Department department);

	List<Agent> findByDepartment(Department department);

	@Query("SELECT a FROM Agent a JOIN FETCH a.department")
	List<Agent> findAllWithDepartment();

   /**
     * @param name
     * @return
     */
    @Query("SELECT a FROM Agent a WHERE a.name LIKE '%:name%'")
	List<Agent> findAllByName(@Param("name") String name);

	/**
     * @param id
     * @return
     */
    Agent getOne(UUID id);

    /**
     * 
     * @param name
     * @return
     */
    List<Agent> findByName(String name);

}
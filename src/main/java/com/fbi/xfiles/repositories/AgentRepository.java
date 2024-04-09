package com.fbi.xfiles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fbi.xfiles.domain.Agent;

public interface AgentRepository extends JpaRepository<Agent, Integer> {
	
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
    Agent getOne(Integer id);

    /**
     * 
     * @param name
     * @return
     */
    List<Agent> findByName(String name);
}
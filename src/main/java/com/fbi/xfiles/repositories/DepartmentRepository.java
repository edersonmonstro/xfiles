package com.fbi.xfiles.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fbi.xfiles.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {

    /**
     * @param name
     * @return
     */
    @Query("SELECT d FROM Department d WHERE d.name LIKE '%:name%'")
	  List<Department> findAllByName(@Param("name") String name);

    /**
     * @param active
     * @return
     */
    @Query("SELECT d FROM Department d WHERE d.active = :active")
	  List<Department> findAllByActive(@Param("active") Boolean active);

     /**
     * @param id
     * @return
     */
    Department getOne(UUID id);

    @Query("SELECT DISTINCT d FROM Department d LEFT JOIN FETCH d.agents")
	  List<Department> findAllWithAgents();

}
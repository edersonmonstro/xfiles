package com.fbi.xfiles.domain.dto;

import java.util.Date;

import com.fbi.xfiles.domain.Agent;
import com.fbi.xfiles.domain.Department;

public class AgentDTO {

	private Integer id;

	private String name;

	private Date birthDate;

	private Department department;

	public AgentDTO() {
	}

	public AgentDTO(Integer id, String name, Date birthDate, Department department) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Agent toAgent() {
		Agent agent = new Agent();
		agent.setId(this.id);
		agent.setName(this.name);
		agent.setBirthDate(this.birthDate);
		agent.setDepartment(this.department);
		return agent;
	}

	public void fromAgent(Agent d) {
		this.id = d.getId();
		this.name = d.getName();
		this.birthDate = d.getBirthDate();
		this.department = d.getDepartment();
	}
}

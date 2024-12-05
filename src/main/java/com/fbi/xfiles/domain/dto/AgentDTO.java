package com.fbi.xfiles.domain.dto;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.fbi.xfiles.domain.Agent;
import com.fbi.xfiles.domain.Department;

public class AgentDTO {

	private UUID id;

	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	private Department department;

	public AgentDTO() {
	}

	public AgentDTO(UUID id, String name, LocalDate birthDate, Department department) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.department = department;
	}

	private AgentDTO(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.birthDate = builder.birthDate;
		this.department = builder.department;
	}

	public static class Builder {
		private UUID id;
		private String name;
		private LocalDate birthDate;
		private Department department;

		public Builder id(UUID id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder birthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Builder department(Department department) {
			this.department = department;
			return this;
		}

		public AgentDTO build() {
			// Adicione validações se necessário
			if (id == null || name == null) {
				throw new IllegalArgumentException("ID and Name are required");
			}
			return new AgentDTO(this);
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
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

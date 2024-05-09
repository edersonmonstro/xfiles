package com.fbi.xfiles.domain.dto;

import java.util.Date;
import java.util.UUID;

import com.fbi.xfiles.domain.Department;

public class DepartmentDTO {

	private UUID id;

	private String name;

	private Date creationDate;

	private String email;

	public DepartmentDTO() {
	}

	public DepartmentDTO(UUID id, String name, Date creationDate, String email) {
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.email = email;
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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department toDepartment() {
		Department department = new Department();
		department.setId(this.id);
		department.setName(this.name);
		department.setCreationDate(this.creationDate);
		department.setEmail(this.email);
		return department;
	}

	public void fromDepartment(Department d) {
		this.id = d.getId();
		this.name = d.getName();
		this.creationDate = d.getCreationDate();
		this.email = d.getEmail();
	}
}

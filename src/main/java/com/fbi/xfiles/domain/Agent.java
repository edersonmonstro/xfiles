package com.fbi.xfiles.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "agent")
public class Agent implements Serializable {

	private static final long serialVersionUID = -7062162719876554818L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
	
	@ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

	public Agent(UUID id, String name, LocalDate birthDate, Department department) {
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.department = department;
	}

	public Agent(String name, LocalDate birthDate, Department department) {
		this.name = name;
		this.birthDate = birthDate;
		this.department = department;
	}

	public Agent() {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthDate, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agent other = (Agent) obj;
		return Objects.equals(birthDate, other.birthDate) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(department, other.department);
	}

	@Override
	public String toString() {
		return "Agent [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", department=" + department + "]";
	}

}
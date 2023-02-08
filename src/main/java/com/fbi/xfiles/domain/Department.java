package com.fbi.xfiles.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1393642021523361954L;

	@Id
	@Column
	@GeneratedValue
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column
	private Date creationDate;

	@Column
	private String email;

	public Department() {
	}

	public Department(Integer id, String name, Date creationDate, String email) {
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.email = email;
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

	@Override
	public int hashCode() {
		return Objects.hash(creationDate, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(creationDate, other.creationDate) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", email=" + email + "]";
	}

}
package com.fbi.xfiles.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;


@Entity
@Table(name = "department")
public class Department implements Serializable {

	private static final long serialVersionUID = 1393642021523361954L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false)
	private String name;

	@Column
	private Date creationDate;

	@Column
	private String email;

	@Column
	private Boolean active;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Agent> agents;

	public Department() {
	}

	public Department(UUID id, String name, Date creationDate, String email, Boolean active) {
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.email = email;
		this.active = active;
	}

	public Department(String name, Date creationDate, String email, Boolean active) {
		this.name = name;
		this.creationDate = creationDate;
		this.email = email;
		this.active = active;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<Agent> getAgents(){
		return agents;
	}

	public void setAgents(List<Agent> agents){
		this.agents = agents;
	}

	@Override
	public int hashCode() {
		return Objects.hash(creationDate, email, id, name, active);
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
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(active, other.active);
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", email=" + email + ", active=" + active + "]";
	}

	@PreRemove
    private void preRemove() {
        if (!agents.isEmpty()) {
            throw new RuntimeException("Agents allocated in this Department");
        }
    }

}